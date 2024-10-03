val scala3Version = "3.4.0"
val circeVersion = "0.14.1"
val scalatestVersion = "3.2.9"

ThisBuild / organization := "io.github.jqscala"
ThisBuild / homepage := Some(url("https://github.com/jqscala/jqscala"))
ThisBuild / licenses := List("Creative Commons" -> url("https://creativecommons.org/licenses/by-nc-sa/4.0/"))
ThisBuild / developers := List(
  Developer(
    "Juan Manuel Serrano Hidalgo",
    "juanmanuel.serrano@hablapps.com",
    "info@hablapps.com",
    url("https://hablapps.com")
  )
  // add more devs here
)

ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"

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
      "org.scalatest" %% "scalatest" % scalatestVersion % Test
    )
  )
