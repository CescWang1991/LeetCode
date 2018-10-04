import scala.collection.mutable

object ValidParenthesesScala {

  def main(args: Array[String]): Unit = {
    val s = "{}([]){}}"
    println(isValid(s))
  }

  val mappings = new mutable.HashMap[Char, Char]()
  mappings.put(')', '(')
  mappings.put(']', '[')
  mappings.put('}', '{')

  def isValid(s: String): Boolean = {
    val stack = new mutable.Stack[Char]()
    s.foreach(c => if(mappings.contains(c)){
      if(stack.isEmpty){
        return false
      } else {
        if(!stack.pop().equals(mappings(c))) { return false }
      }
    } else{
      stack.push(c)
    })
    stack.isEmpty
  }
}
