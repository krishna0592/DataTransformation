package interview

object Matrix {
  val m = 3
  val n = 3
  var arr = Array.ofDim[Int](m,n)

  var cp = "0,0"
  var r = cp.split(",")(0).toInt
  var c = cp.split(",")(1).toInt

  def rowInc(rows: Int, column: Int): Unit ={
    if(column < m){
      println(arr(r)(c))
      c = c+1
    }
    print(r,c)
  }

  def spiralPrinting(): Unit ={
    arr(0)(0) = 1
    arr(0)(1) = 2
    arr(0)(2) = 3
    arr(1)(0) = 4
    arr(1)(1) = 5
    arr(1)(2) = 6
    arr(2)(0) = 7
    arr(2)(1) = 8
    arr(2)(2) = 9

    print(r,c)

  }
}
