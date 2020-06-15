name := "TestProject"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.4",
  "org.apache.spark" %% "spark-sql" % "2.4.4",
  "org.apache.logging.log4j" % "log4j-core" % "2.13.0"
  //"org.apache.spark" %% "spark-streaming" % "2.4.4" % "provided"
)

publishTo := Some(Resolver.file("local-ivy", file("/Users/divya.dua/Documents/spark-streaming")))
