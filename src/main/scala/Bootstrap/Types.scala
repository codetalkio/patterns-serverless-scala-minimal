import scala.util.Try

import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._

// The response written to the response url by the function.
case class LambdaResponse(
    statusCode: Int,
    headers: Map[String, String],
    body: String,
    isBase64Encoded: Boolean = false
) {
  private implicit val codec: JsonValueCodec[LambdaResponse] = {
    JsonCodecMaker.make[LambdaResponse](CodecMakerConfig)
  }

  def toJson: String = {
    writeToString(this)
  }
}

case class RequestIdentity(
    apiKey: Option[String],
    userArn: Option[String],
    cognitoAuthenticationType: Option[String],
    caller: Option[String],
    userAgent: Option[String],
    user: Option[String],
    cognitoIdentityPoolId: Option[String],
    cognitoAuthenticationProvider: Option[String],
    sourceIp: Option[String],
    accountId: Option[String]
)

case class RequestContext(
    resourceId: String,
    apiId: String,
    resourcePath: String,
    httpMethod: String,
    accountId: String,
    stage: String,
    identity: RequestIdentity,
    extendedRequestId: Option[String],
    path: String
)

// The request returned from the next-event url.
case class RequestEvent(
    httpMethod: String,
    body: Option[String],
    resource: String,
    requestContext: RequestContext,
    queryStringParameters: Option[Map[String, String]],
    headers: Option[Map[String, String]],
    pathParameters: Option[Map[String, String]],
    stageVariables: Option[Map[String, String]],
    path: String,
    isBase64Encoded: Boolean
)

object RequestEvent {
  private implicit val codec: JsonValueCodec[RequestEvent] = {
    JsonCodecMaker.make[RequestEvent](CodecMakerConfig)
  }

  def fromJsonSafe(s: String): Option[RequestEvent] = {
    Try(readFromString[RequestEvent](s)) match {
      case util.Success(re) => Some(re)
      case util.Failure(ex) =>
        Console.err.println(
          s"Failed to parse body into RequestEvent: $ex \nbody: $s"
        ); None
    }
  }
}
