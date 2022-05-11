ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "zstream-oom",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "1.0.14",
      "dev.zio" %% "zio-streams" % "1.0.14",
      "dev.zio" %% "zio-nio" % "1.0.0-RC12",
    )
  )
