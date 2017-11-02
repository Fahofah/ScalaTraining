name := "Training"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.7.25",
  "mysql" % "mysql-connector-java" % "6.0.6",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1"
)