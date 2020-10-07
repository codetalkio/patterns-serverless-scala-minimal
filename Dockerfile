FROM oracle/graalvm-ce:20.2.0

RUN gu install native-image

WORKDIR /tmp/sls-graalvm-dist
CMD native-image \
    --enable-url-protocols=http \
    --report-unsupported-elements-at-runtime \
    --no-fallback \
    -jar /tmp/sls-graalvm-target/bootstrap.jar \
    bootstrap
