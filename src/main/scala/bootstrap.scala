object bootstrap {
  def main(args: Array[String]): Unit = {
    val runtimeApiHost = sys.env("AWS_LAMBDA_RUNTIME_API")
    Console.err.println(s"Could not handle event: $runtimeApiHost")
    handleEvents(runtimeApiHost)
  }

  // Receive and handle events infinitely
  def handleEvents(runtimeApiHost: String): Unit = {
    val nextEventUrl = getNextEventUrl(runtimeApiHost)
    while (true) {
      val r = requests.get(nextEventUrl)
      val statusCode = for {
        requestEvent <- RequestEvent.fromJsonSafe(r.text())
        deadlineMs <- getRequiredHeader(r, "lambda-runtime-deadline-ms").map(_.toLong)
        requestId <- getRequiredHeader(r, "lambda-runtime-aws-request-id")
        statusCode = handleRequest(runtimeApiHost, requestEvent, requestId, deadlineMs)
      } yield statusCode

      if (statusCode.isEmpty) {
        Console.err.println(s"Could not handle event: $r")
      }
    }
  }

  // Retrieve the specified header from the response. If not available, report the header as missing
  def getRequiredHeader(nextEventResponse: requests.Response, header: String): Option[String] = {
    nextEventResponse.headers.get(header).map(_.head).orElse {
      Console.err.println(s"Next event request did not include this required header: $header")
      Console.err.println(s"headers: ${nextEventResponse.headers}")
      None
    }
  }

  // Handle a valid request to this function
  def handleRequest(host: String, requestEvent: RequestEvent, requestId: String, deadlineMs: Long): Int = {
    requestEvent.pathParameters.flatMap(_.get("name")) match {
      case Some(name) =>
        val response = LambdaResponse("200", Map("Content-Type" -> "text/plain"), s"Hello, $name!\n")
        requests.post(getResponseUrl(host, requestId), data = response.toJson).statusCode
      case None =>
        val response = LambdaResponse("400", Map("Content-Type" -> "text/plain"), "'name' param not found\n")
        requests.post(getResponseUrl(host, requestId), data = response.toJson).statusCode
    }
  }

  // The url used to retrieve the next function request
  def getNextEventUrl(host: String) =
    s"http://$host/2018-06-01/runtime/invocation/next"

  // The url used to write a response back to the caller
  def getResponseUrl(host: String, requestId: String) =
    s"http://$host/2018-06-01/runtime/invocation/$requestId/response"

}
