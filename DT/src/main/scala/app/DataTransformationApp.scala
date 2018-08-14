package app

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.joda.time.DateTime
import services.{Dataframe, EMI_Calculation}
import utils._
import interview.Matrix._

object DataTransformationApp {

  var sc: SparkContext = _
  var spark_session: SparkSession = _
  var now: DateTime = _
  sc = Initialization.sparkSession()
  val spark = spark_session

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    spiralPrinting()
  }
}


// EMI calculator --> take inputs from users and prepare a emi chart for duration mentioned
// survey app --> send a survey question and based on the response obtained prepare a graph