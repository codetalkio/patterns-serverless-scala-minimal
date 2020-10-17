import BootstrapEvent._;

object bootstrap {

  /** The entrypoint of the AWS provided runtime.
    */
  def main(args: Array[String]): Unit = {
    val awsLambdaRuntimeAPI = sys.env("AWS_LAMBDA_RUNTIME_API")
    Console.err.println(
      s"Error in bootstrap: Could not handle event, running runtime API host '$awsLambdaRuntimeAPI'"
    )
    BootstrapEvent.processEvent(awsLambdaRuntimeAPI)
  }

}
