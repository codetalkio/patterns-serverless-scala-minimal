import * as core from "@aws-cdk/core";
import * as lambda from "@aws-cdk/aws-lambda";
import * as s3 from "@aws-cdk/aws-s3";
import * as cdk from "@aws-cdk/core";

interface Props {}

export class LambdaStack extends core.Stack {
  constructor(scope: cdk.App, id: string, props: Props) {
    super(scope, id);

    // Our Lambda function details.
    const entryId = "main";
    const entryFnName = `${id}-${entryId}`;
    const entry = new lambda.Function(this, entryId, {
      functionName: entryFnName,
      description: "Scala serverless minimal microservice",
      runtime: lambda.Runtime.PROVIDED_AL2,
      handler: `bootstrap.main`,
      code: lambda.Code.fromAsset(`${__dirname}/../../dist`),
      memorySize: 256,
      timeout: cdk.Duration.seconds(10),
      tracing: lambda.Tracing.ACTIVE,
    });

    // Our Lambda function environment variables.
    entry.addEnvironment("AWS_NODEJS_CONNECTION_REUSE_ENABLED", "1");

    // Tag our resource.
    core.Aspects.of(entry).add(new cdk.Tag("service-type", "API"));
    core.Aspects.of(entry).add(new cdk.Tag("billing", `lambda-${entryFnName}`));
    // CloudFormation exports.
    new cdk.CfnOutput(this, `${entryFnName}-arn`, {
      description: `AWS ARN for the ${entryFnName} lambda resource`,
      exportName: `${entryFnName}-function-arn`,
      value: entry.functionArn,
    });
  }
}
