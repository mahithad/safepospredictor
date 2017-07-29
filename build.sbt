import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.puzzsupport",
      scalaVersion := "2.12.1",
      version      := "1.0-SNAPSHOT"
    )),
    name := "JPModule",
    libraryDependencies += scalaTest % Test
  )
