package file_io

import app.DataTransformationApp._
import org.apache.spark.sql.DataFrame

class TEXT {

  def read(filePath: String, fileName: String): DataFrame = {
    // reading text file without schema
    spark.read.option("header", "true").csv(filePath + "/" + fileName)

    /*
     * Testing:
     *    1. test the below code also
     *    2. read more than one text file from a directory as one dataframe
     *    3. read more than one text file from more than one directory as one dataframe
     *
     * reading with Schema
     * val schemaString: String = "name,age,city"
     * val fields= schemaString.split(",").map(fieldName => StructField(fieldName,StringType,nullable = true))
     * val schema = StructType(schema)
    */
  }

  def write(dataFrame: DataFrame, filePath: String, fileName: String): Unit = {
    dataFrame.coalesce(1).write.text(filePath + "/" + fileName)

    /*
     * Testing:
     *    1. change the coalesece value as >1 and write and check whether expected no of files are created
     *    2. change the mode as append and write
     *
     */
  }
}
