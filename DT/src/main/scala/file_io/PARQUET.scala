package file_io

import app.DataTransformationApp._
import org.apache.spark.sql.DataFrame

class PARQUET {

  def read(filePath: String, fileName: String): DataFrame = {
    spark.read.parquet(filePath + "/" + fileName)

    /*
     * Testing:
     *    1. read one file from a directory
     *    2. read more than one file from a directory as a single dataframe
     *    3. read more than one file from more than one directory as a single dataframe
     */
  }

  def write(dataFrame: DataFrame, filePath: String, fileName: String): Unit = {
    dataFrame.coalesce(1).write.mode("overwrite").parquet(filePath + "/" + fileName)

    /*
     * Testing:
     *    1. change the coalesece value as >1 and write and check whether expected no of files are created
     *    2. change the mode as append and write
     *
     */
  }

}
