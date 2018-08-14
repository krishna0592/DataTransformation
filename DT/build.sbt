name := "DataTransformation"

version := "0.1"

scalaVersion := "2.11.11"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0"

//libraryDependencies ++= Seq( "joda-time" % "joda-time" % "2.3" % "provided")
libraryDependencies += "joda-time" % "joda-time" % "2.9.9"

// https://mvnrepository.com/artifact/com.crealytics/spark-excel
libraryDependencies += "com.crealytics" %% "spark-excel" % "0.8.3"
