FROM oracle/graalvm-ce:20.1.0
# NOTE: Because of https://github.com/oracle/graal/issues/2770 we stick to 20.1.0.

RUN gu install native-image

ENV AWS_LAMBDA_RUNTIME_API="0.0.0"

WORKDIR /tmp/sls-graalvm-dist
CMD native-image \
    --enable-url-protocols=http \
    --report-unsupported-elements-at-runtime \
    --allow-incomplete-classpath \
    --initialize-at-build-time \
    -H:+ReportExceptionStackTraces \
    -H:+ReportUnsupportedElementsAtRuntime \
    -H:+StackTrace \
    --no-fallback \
    -H:ConfigurationFileDirectories=/tmp/sls-graalvm-dist/META-INF \
    -jar /tmp/sls-graalvm-target/bootstrap.jar \
    bootstrap

