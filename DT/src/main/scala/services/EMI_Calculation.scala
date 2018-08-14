package services

import app.DataTransformationApp._
import org.apache.spark.sql.DataFrame
import spark.implicits._

class EMI_Calculation {

  def emi_chart(): Unit = {
    var p: Double = 1000000
    val r: Double = 8.4 //in percentage
    val n: Int = 10 // in years

    var arr: Array[(Int, Long, Long, Long, Long, Long)] = Array()
    val r_pm: Double = (r / 12) / 100
    val months = n * 12

    val numerator: Double = Math.pow(1 + r_pm, months)
    val denominator: Double = numerator - 1
    val emi_pm: Double = (p * (r_pm * numerator)) / denominator

    for (i <- 1 to (n * 12)) {
      val r_pm_value: Double = p * r_pm
      val p_debited: Double = emi_pm - r_pm_value
      val outstanding_p: Double = p - p_debited
      arr = if (i != 1) arr :+ (i, p.round, emi_pm.round, r_pm_value.round, p_debited.round, outstanding_p.round) else arr :+ (1, p.round, emi_pm.round, r_pm_value.round, p_debited.round, outstanding_p.round)
      p = outstanding_p
    }
    val df: DataFrame = {
      sc.parallelize(arr).toDF("Months", "Principle", "EMI value", "Interest Per Month", "Principle Per Month", "Outstanding Principle")
    }
    df.show(months, false)
  }
}