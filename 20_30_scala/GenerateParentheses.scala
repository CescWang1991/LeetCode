import scala.collection.mutable

/**
  * Closure Number：
  *
  * To enumerate something, generally we would like to express it as a sum of disjoint subsets that are easier to count.
  * Consider the closure number of a valid parentheses sequence S: the least index >= 0 so that S[0], S[1], ...,
  * S[2*index+1] is valid.
  *
  * For each closure number c, we know the starting and ending brackets must be at index 0 and 2*c + 1. Then, the 2*c
  * elements between must be a valid sequence, plus the rest of the elements must be a valid sequence.
  */
object GenerateParentheses {
  def generateParenthesis(n: Int): List[String] = {
    val list = mutable.ListBuffer.empty[String]
    if(n == 0){
      list += ""
    }  else {
      for(l <- 0 until n){
        val r = n - l - 1
        val left = generateParenthesis(l)
        val right = generateParenthesis(r)
        left.foreach(ls => right.foreach(rs => list += "(" + ls + ")" + rs))
      }
    }
    list.toList
  }
}
