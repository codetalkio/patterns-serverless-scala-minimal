object Bootstrap {
  def processEvent(runtimeApiHost: String): Unit = {
    val nextEventUrl = getNextEventUrl(runtimeApiHost)
    while (true) {
      val r = requests.get(nextEventUrl)
      val statusCode = for {
        requestEvent <- RequestEvent.fromJsonSafe(r.text())
        deadlineMs <-
          getRequiredHeader(r, "lambda-runtime-deadline-ms").map(_.toLong)
        requestId <- getRequiredHeader(r, "lambda-runtime-aws-request-id")
        lambdaResponse = Handler.handle(requestEvent, deadlineMs)
        statusCode =
          requests
            .post(
              Bootstrap.getResponseUrl(runtimeApiHost, requestId),
              data = lambdaResponse.toJson
            )
            .statusCode
      } yield statusCode

      if (statusCode.isEmpty) {
        Console.err.println(s"Could not handle event: $r")
      }
    }
  }

  // Retrieve the specified header from the response. If not available, report the header as missing
  def getRequiredHeader(
      nextEventResponse: requests.Response,
      header: String
  ): Option[String] = {
    nextEventResponse.headers.get(header).map(_.head).orElse {
      Console.err.println(
        s"Next event request did not include this required header: $header"
      )
      Console.err.println(s"headers: ${nextEventResponse.headers}")
      None
    }
  }

  // The url used to retrieve the next function request
  def getNextEventUrl(host: String) =
    s"http://$host/2018-06-01/runtime/invocation/next"

  // The url used to write a response back to the caller
  def getResponseUrl(host: String, requestId: String) =
    s"http://$host/2018-06-01/runtime/invocation/$requestId/response"

}
