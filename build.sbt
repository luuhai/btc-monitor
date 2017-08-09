name := "btc-monitor"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.19",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.19" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.13.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test")

val circeVersion = "0.8.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)