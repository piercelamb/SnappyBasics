name := "SnappyBasics"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "io.snappydata" % "snappydata-core_2.11" % "0.8",
  "io.snappydata" % "snappy-spark-core_2.11" % "2.0.3-2",
  "io.snappydata" % "snappy-spark-sql_2.11" % "2.0.3-2"
)
    