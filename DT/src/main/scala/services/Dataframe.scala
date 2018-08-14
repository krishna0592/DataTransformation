package services

import app.DataTransformationApp._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row} //supports operation performed on a Row


object Dataframe {

  def createEmptyDataFrame(): Unit = {
    val schema = new StructType().add("a", "int").add("b", "string")
    val a = spark.createDataFrame(sc.emptyRDD[Row], schema)
    a.show
  }



  def fillMissingValue(): Unit ={
    // na operations
  }

  // udf to cast the columns in a dataframe / rdd
  //

}
