name := "btc-monitor"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.19",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.19" % "test",
  "com.typesafe.akka" %% "akka-http" % "10.0.9",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test")
