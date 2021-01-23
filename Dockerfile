FROM ghcr.io/graalvm/graalvm-ce:java11-21.0.0
# NOTE: Because of https://github.com/scala/bug/issues/11634 we use 20.3.0-java11.

RUN gu install native-image

ENV AWS_LAMBDA_RUNTIME_API="0.0.0"
ENV _HANDLER="handle"

WORKDIR /tmp/sls-graalvm-dist
CMD native-image \
    --no-fallback \
    --static \
    --enable-url-protocols=http \
    --initialize-at-build-time \
    --initialize-at-build-time=scala.runtime.Statics$VM \
    -Djava.net.preferIPv4Stack=true \
    -H:+ReportExceptionStackTraces \
    -H:+StackTrace \
    -H:ConfigurationFileDirectories=/tmp/sls-graalvm-dist/META-INF \
    -jar /tmp/sls-graalvm-target/bootstrap.jar \
    bootstrap
