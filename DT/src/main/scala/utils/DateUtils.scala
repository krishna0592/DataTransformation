package utils

import java.util.Date
import org.joda.time.{DateTime, Seconds}
//import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {

  val now: Calendar = Calendar.getInstance()


  //parse the given input string as date
  def dateParse(format: String, ipDate: String): Date = new SimpleDateFormat(format).parse(ipDate)


  // format string to date
  def dateFormatter(format: String, ipDate: java.util.Date): String = new SimpleDateFormat(format).format(ipDate)


  // converts string to date
  def stringToDate(date: String): java.time.LocalDate = LocalDate.parse(date)


  //finds the difference between two time
  def runTimeCalculation(start: DateTime, end: DateTime): String = Seconds.secondsBetween(start, end).toString.substring(2)


  //get the current date and time in required format
  def currentTime(opFormat: String): String = {
    //Approach 1:
    //val formatter = DateTimeFormat.forPattern(ipFormat)
    //DateTime.now.toString(formatter)

    //Approach 2:
    dateFormatter(opFormat, Calendar.getInstance().getTime)
  }


  //both date addition and date subtraction operation needs to be done based on the days to add argument
  def dateAdd(date: String, ipFormat: String, opFormat: String, days: Int): String = {
    //Approach 1:
    //import org.joda.time.DateTime
    //import org.joda.time.format.DateTimeFormat
    //DateTime.parse(date, DateTimeFormat.forPattern(IPformat)).plusDays(days).toString(OPformat)

    //Approach 2:
    now.setTime(dateParse(ipFormat, date))
    now.add(Calendar.DATE, days)
    dateFormatter(opFormat, now.getTime)
  }


  //If field to be extracted is given as min, extract only the minutes for the date and return
  def dateExtract(date: String, ipFormat: String, field: String): String = {
    now.setTime(dateParse(ipFormat, date))
    field match {
      case "year" => dateFormatter("Y", now.getTime)
      case "monthOfYear" => dateFormatter("MM", now.getTime)
      case "monthOfYearAsString" => dateFormatter("MMMMM", now.getTime)
      case "monthOfYearAsShortString" => dateFormatter("MMMM", now.getTime)
      case "dayOfYear" => dateFormatter("DDD", now.getTime)
      case "dayOfMonth" => dateFormatter("d", now.getTime)
      case "dayOfWeek" => dateFormatter("F", now.getTime)
      case "dayOfWeekAsString" => dateFormatter("EEEEE", now.getTime)
      case "dayOfWeekAsShortString" => dateFormatter("E", now.getTime)
      case "hourOfDay12HourFormat" => dateFormatter("hh", now.getTime) // if time details is not given in the ip format then default time will be considered as 12:00:00 and this details will be returned
      case "hourOfDay24HourFormat" => dateFormatter("HH", now.getTime)
      case "minOfHour" => dateFormatter("mm", now.getTime)
      case "secondInMin" => dateFormatter("ss", now.getTime)
      case "milliSecondInSeconds" => dateFormatter("SSS", now.getTime)
      case "weekOfYear" => dateFormatter("ww", now.getTime)
      case "weekOfMonth" => dateFormatter("WW", now.getTime)
      case "amOrpm" => dateFormatter("a", now.getTime)
      case "timeZone" => dateFormatter("z", now.getTime)
      case _ => "Invalid Field"
    }
  }


  //convert the date from one format to other format
  def dateFormatConversion(date: String, ipFormat: String, opFormat: String): String = {
    now.setTime(dateParse(ipFormat, date))
    dateFormatter(opFormat, now.getTime)

  }


  //find the difference between two dates and returns the value in required format
  def datediff(date1: String, date1_ipFormat: String, date2: String, date2_ipFormat: String): Long = {
    LocalDate.parse(date1, DateTimeFormatter.ofPattern(date1_ipFormat)).toEpochDay - LocalDate.parse(date2, DateTimeFormatter.ofPattern(date2_ipFormat)).toEpochDay + 1
  }

}
