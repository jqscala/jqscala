val scala3Version = "3.4.0"
val circeVersion = "0.14.1"
val scalatestVersion = "3.2.9"
val fs2Version = "3.8.0"

lazy val root = project
  .in(file("."))
  .settings(
    organization := "jqscala",
    name := "jqscala",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    Test / packageBin / publishArtifact := true,

    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "co.fs2" %% "fs2-core" % fs2Version,
      "org.scalatest" %% "scalatest" % scalatestVersion % Test
    )
  )
