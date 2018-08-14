package file_io

import app.DataTransformationApp._
import org.apache.spark.sql.DataFrame

class XLSX {

  def read(filePath: String, fileName: String): DataFrame = {
    spark.read.format("com.crealytics.spark.excel")
      .option("location", filePath + "/" + fileName)
      .option("useHeader", "true")
      .option("treatEmptyValuesAsNulls", "true")
      .option("inferSchema", "true")
      .option("addColorColumns", "False")
      .load()

    /*
     * Other options:
     *    1 .option("sheetName", "Sheet2")
     *    2 .option("startColumn", 0)                         Optional, default: 0
     *    3 .option("endColumn", 99)                          Optional, default: Int.MaxValue
     *    4 .option("timestampFormat", "MM-dd-yyyy HH:mm:ss") Optional, default: yyyy-mm-dd hh:mm:ss[.fffffffff]
     *    5 .option("maxRowsInMemory", 20)                    Optional, default None. If set, uses a streaming reader which can help with big files
     *    6 .option("excerptSize", 10)                        Optional, default: 10. If set and if schema inferred, number of rows to infer schema from
     *    7 .schema(myCustomSchema)                           Optional, default: Either inferred schema, or all columns are Strings
     */

    /*
     * Testing:
     *    1. read one file from a directory
     *    2. read more than one file from a directory as a single dataframe
     *    3. read more than one file from more than one directory as a single dataframe
     */
  }

  def write(dataFrame: DataFrame, filePath: String, fileName: String): Unit = {
    dataFrame.coalesce(1).write
      .format("com.crealytics.sparl.excel")
      .option("sheetName", "sheet1")
      .option("useHeader", "true")
      .mode("overwrite")
      .save(filePath + "/" + fileName)

    /*
     * Other Options:
     *    1 .option("dateFormat", "yy-mmm-d")                 Optional, default: yy-m-d h:mm
     *    2 .option("timestampFormat", "mm-dd-yyyy hh:mm:ss") Optional, default: yyyy-mm-dd hh:mm:ss.000
     */

    /*
     * Testing:
     *    1. change the coalesece value as >1 and write and check whether expected no of files are created
     *    2. change the mode as append and write
     *
     */
  }

}
