import scala.math.pow
/**
  * Given a 32-bit signed integer, reverse digits of an integer.
  */

object ReverseInteger {
  def main(args: Array[String]): Unit = {
    val num = 1245356486
    println(reverse(num))
  }

  def reverse(x: Int): Int = {
    var output = 0
    var y = x

    while(y != 0){
      val dig = y % 10
      y /= 10
      // 判断字段溢出
      if(output * 10 + dig >= pow(2, 31).toInt || output * 10 + dig <= -pow(2, 31).toInt - 1){ output = 0 }
      else { output = output * 10 + dig }
    }

    output
  }
}
