name := "btc-monitor"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.12",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.12" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test")
