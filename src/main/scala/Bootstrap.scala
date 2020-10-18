/** Our custom runtime object. The AWS runtime runs this as an executable, and expects us
  * to handle the rest.
  *
  * Interested in knowing more about how it all works? Check out the Walkthrough of creating
  * you own runtime: https://docs.aws.amazon.com/lambda/latest/dg/runtimes-walkthrough.html.
  */
object Bootstrap {

  /** The entrypoint of the AWS provided runtime. */
  def main(args: Array[String]): Unit = {
    val awsLambdaRuntimeAPI = sys.env("AWS_LAMBDA_RUNTIME_API")
    val awsLambdaHandler = sys.env("_HANDLER")
    val nextEventUrl =
      s"http://$awsLambdaRuntimeAPI/2018-06-01/runtime/invocation/next"

    Console.err.println(s"Requesting $awsLambdaRuntimeAPI...")

    while (true) {
      val runtimeResponse = requests.get(nextEventUrl)

      // TODO: Handle the response body in a more robust way.
      // requestEvent <- RequestEvent.fromJsonSafe(runtimeResponse.text())
      // runtimeResponse.text() => (Full request body,{"firstName": "world"})
      // Response(http://127.0.0.1:9001/2018-06-01/runtime/invocation/next,200,OK,{"firstName": "world"},HashMap(lambda-runtime-invoked-function-arn -> List(arn:aws:lambda:eu-central-1:388072253866:function:sls-benchmark-31721), content-length -> List(22), date -> List(Sun, 18 Oct 2020 10:12:09 GMT), content-type -> List(application/json), lambda-runtime-trace-id -> List(Root=1-5f8c14f6-7a4d438b1734e19455e65c47;Parent=7303de1783bc5e13;Sampled=1), lambda-runtime-aws-request-id -> List(c144e7ae-ca48-409f-8252-3cc867061dde), lambda-runtime-deadline-ms -> List(1603015929242)),None)

      val deadlineMs =
        runtimeResponse.headers("lambda-runtime-deadline-ms").head.toLong
      val requestId = runtimeResponse
        .headers("lambda-runtime-aws-request-id")
        .head

      val errorResponseUrl =
        s"http://$awsLambdaRuntimeAPI/2018-06-01/runtime/invocation/$requestId/error"
      val successResponseUrl =
        s"http://$awsLambdaRuntimeAPI/2018-06-01/runtime/invocation/$requestId/response"
      val requestUrl = successResponseUrl
      val statusCode =
        try {
          val lambdaResponse =
            Handler.handle(runtimeResponse.text(), deadlineMs)
          requests
            .post(
              successResponseUrl,
              data = lambdaResponse.toJson
            )
            .statusCode
        } catch {
          case e: Throwable =>
            Console.err.println(s"Could not handle event: $runtimeResponse")
            val lambdaResponse = LambdaResponse(
              500,
              Map("Content-Type" -> "application/json"),
              e.getMessage
            )
            requests
              .post(
                errorResponseUrl,
                data = lambdaResponse.toJson
              )
              .statusCode
        }
    }
  }

}
