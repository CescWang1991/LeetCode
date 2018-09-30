/**
  * Given a 32-bit signed integer, reverse digits of an integer.
  */

import scala.collection.mutable
import math.pow

object ReverseInteger {
  def main(args: Array[String]): Unit = {
    val num = 123
    println(reverse(num))
  }

  def reverse(x: Int): Int = {
    var output = 0
    var y = x
    var number = 0
    var add = false

    val stack: mutable.Stack[Int] = new mutable.Stack[Int]()
    for(bit <- (0 to 10).reverse){
      number = y / pow(10, bit).toInt
      y = y - number * pow(10, bit).toInt
      if(number != 0 || add){
        stack.push(number)
        add = true
      }
    }

    val numBit = stack.size
    if(numBit >= 11) { output = 0 }
    else {
      for (bit <- (0 until numBit).reverse) {
        if(stack.nonEmpty){
          number = stack.pop
          output = output * 10 + number
        }
      }
    }
    output
  }
}
