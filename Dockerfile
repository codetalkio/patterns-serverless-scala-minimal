FROM oracle/graalvm-ce:19.3.1-java11
# NOTE: Because of https://github.com/scala/bug/issues/11634 we use 19.3.1-java11.

RUN gu install native-image

ENV AWS_LAMBDA_RUNTIME_API="0.0.0"

WORKDIR /tmp/sls-graalvm-dist
CMD native-image \
    --no-fallback \
    --static \
    --enable-url-protocols=http \
    --report-unsupported-elements-at-runtime \
    --allow-incomplete-classpath \
    --initialize-at-build-time \
    -H:+ReportExceptionStackTraces \
    -H:+ReportUnsupportedElementsAtRuntime \
    -H:+StackTrace \
    -H:ConfigurationFileDirectories=/tmp/sls-graalvm-dist/META-INF \
    -jar /tmp/sls-graalvm-target/bootstrap.jar \
    bootstrap

