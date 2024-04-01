val scala3Version = "3.4.0"
val circeVersion = "0.14.1"
val scalatestVersion = "3.2.9"
val fs2Version = "3.8.0"

inThisBuild(List(
  organization := "io.github.jqscala",
  homepage := Some(url("https://github.com/jqscala/jqscala")),
  licenses := List("Creative Commons" -> url("https://creativecommons.org/licenses/by-nc-sa/4.0/")),
  developers := List(
    Developer(
      "Juan Manuel Serrano Hidalgo",
      "juanmanuel.serrano@hablapps.com",
      "info@hablapps.com",
      url("https://hablapps.com")
    )
    // add more devs here
  )
))

lazy val root = project
  .in(file("."))
  .settings(
    name := "jqscala",

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
