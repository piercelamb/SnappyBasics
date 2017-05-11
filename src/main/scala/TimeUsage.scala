import java.nio.file.Paths

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._

/**
  * Created by plamb on 5/9/17.
  */
object TimeUsage {


  val context = new SparkContext(
    new SparkConf()
      .setAppName("Time Usage")
      .setMaster("local[*]")
  )

  val snappy = new SnappySession(context)

  def main(args: Array[String]): Unit = {
    val (columns, initDf) = read("/timeusage/atussum.csv")
    println(columns)
  }

  /** @return The read DataFrame along with its column names. */
  def read(resource: String): (List[String], DataFrame) = {

    val timeDF = snappy.read.option("header", "true")
      .option("inferSchema", "true").csv(fsPath(resource))

    val headerColumns = timeDF.columns.to[List]

    (headerColumns, timeDF)
  }

  /** @return The filesystem path of the given resource */
  def fsPath(resource: String): String =
    Paths.get(getClass.getResource(resource).toURI).toString

}
