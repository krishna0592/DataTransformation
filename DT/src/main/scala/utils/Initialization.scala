package utils

import app.DataTransformationApp._
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object Initialization {

  def sparkContext(): SparkContext = {
    val spark = new SparkConf()
    spark.setMaster("local")
    spark.setAppName("DataTransformation")
    new SparkContext(spark)
  }

  def sparkSession(): SparkContext = {
    spark_session = SparkSession
      .builder()
      .appName(Constants.appName)
      .master("local")
      .getOrCreate()

    // setting the log level
    val rootLogger = Logger.getRootLogger()
    rootLogger.setLevel(Level.ERROR)

    /*
     * .config("spark.sql.warehouse.dir", Constants.wareHouseLocation)
     * .config("spark.cassandra.connection.port", Constants.cassandraPort)
     * .config("spark.cassandra.auth.username", Constants.cassandraUserName)
     * .config("spark.cassandra.auth.password", Constants.cassandraPassword)
     * set new runtime options
     * spark.conf.set("spark.sql.shuffle.partitions", 6)
     * spark.conf.set("spark.executor.memory", "2g")
     *
     * get all settings
     * val configMap: Map[String, String] = spark.conf.getAll
     */

    spark_session.sparkContext

  }


}
