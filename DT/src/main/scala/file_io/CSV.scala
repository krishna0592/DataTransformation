package file_io

import app.DataTransformationApp._
import org.apache.spark.sql.DataFrame

class CSV {

  def read(filePath: String, fileName: String): DataFrame ={
    spark.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", ",")
      .load(filePath + "/" + fileName)

    /*
     * Testing:
     *    1. read one file from a directory
     *    2. read more than one file from a directory as a single dataframe
     *    3. read more than one file from more than one directory as a single dataframe
     *      paths = "dir1/,dir2/,dir3/'*'"  dont use the single quotes while testing, it is used to hear to overcome line comment issue
     *      df = spark.read.format("csv").option("header", "false").schema(custom_schema).option('delimiter', '\t').option('mode', 'DROPMALFORMED').load(paths.split(','))
     *
     */
  }

  def write(dataFrame: DataFrame, filePath: String, fileName: String): Unit ={
    dataFrame.coalesce(1).write.format("com.databricks.spark.csv")
      .mode("overwrite")
      .option("header", "true")
      .option("delimiter", ",")
      .save(filePath + "/" + fileName)

    /*
     * Note: By default repartition count is considered as 1
     *
     * Testing:
     *    1. change the coalesece value as >1 and write and check whether expected no of files are created
     *    2. change the mode as append and write
     *
     */
  }

  def trimColumn(): Unit ={

  }

  def PrintHeader(): Unit ={

  }




  /*
    * def main(args: Array[String]): Unit = {
    val csv = sc.textFile("/path/to/your/file.csv")

    // split / clean data
    val headerAndRows = csv.map(line => line.split(",").map(_.trim))
    // get header
    val header = headerAndRows.first
    // filter out header (eh. just check if the first val matches the first header name)
    val data = headerAndRows.filter(_(0) != header(0))
    // splits to map (header/value pairs)
    val maps = data.map(splits => header.zip(splits).toMap)
    // filter out the user "me"
    val result = maps.filter(map => map("user") != "me")
    // print result
    result.foreach(println)
  }
   *
   */
}
