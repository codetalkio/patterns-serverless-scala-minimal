name := "sls-scala-minimal"
scalaVersion := "2.13.3"
assemblyJarName in assembly := "bootstrap.jar"
mainClass in assembly := Some("Bootstrap")

libraryDependencies ++= Seq(
  "com.lihaoyi" %% "requests" % "0.6.5",
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.6.2",
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.6.2" % Provided, // only required in compile-time
  // Check out https://github.com/scala/bug/issues/11634 for why these are necessary.
  "org.graalvm.nativeimage" % "svm" % "20.1.0" % "compile-internal",
  "org.scalameta" %% "svm-subs" % "20.1.0" % "compile-internal"
)

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding",
  "utf-8", // Specify character encoding used by source files.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings" // Fail the compilation if there are any warnings.
)
