object Handler {
  // Handle a valid request to this function
  def handle(requestEvent: String, deadlineMs: Long): LambdaResponse = {
    LambdaResponse(
      200,
      Map("Content-Type" -> "application/json"),
      s"Hello, World!\n"
    )
    // requestEvent.pathParameters.flatMap(_.get("name")) match {
    //   case Some(name) =>
    //     LambdaResponse(
    //       200,
    //       Map("Content-Type" -> "application/json"),
    //       s"Hello, $name!\n"
    //     )
    //   case None =>
    //     LambdaResponse(
    //       200,
    //       Map("Content-Type" -> "application/json"),
    //       s"Hello, World!\n"
    //     )
    // }
  }

}
