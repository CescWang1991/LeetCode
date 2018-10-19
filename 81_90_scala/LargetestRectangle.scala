import scala.collection.mutable

object LargetestRectangle {

  def main(args: Array[String]): Unit = {
    val heights = Array[Int](3,3,6,5,8,2,7,4)
    println(largestRectangleArea(heights))
  }

  def largestRectangleArea(heights: Array[Int]): Int = {
    if(heights.length == 0) { return 0 }
    val len = heights.length
    val array = heights :+ -1
    var max = 0
    val stack = new mutable.Stack[Int]
    var i = 0
    while (i <= len){
      println("iter: "+i)
      if(stack.isEmpty || array(i) >= array(stack.head)){
        stack.push(i)
        i += 1
      } else {
        val h = array(stack.pop())
        if(stack.isEmpty){
          max = Math.max(max, h * i)
        } else {
          max = Math.max(max, h * (i - stack.head - 1))
        }
      }
      println(stack+" max: "+max)
    }
    max
  }
}
