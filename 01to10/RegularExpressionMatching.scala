/**
  * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
  */
object RegularExpressionMatching {

  def main(args: Array[String]): Unit = {
    val s = "ab"
    val p = ".*c"
    println(isMatch(s, p))
  }

  def isMatch(s: String, p: String): Boolean = {
    var matched = false
    var firstMatch = false

    if(s.nonEmpty && p.nonEmpty){
      firstMatch = s.charAt(0).equals(p.charAt(0)) || p.charAt(0).equals('.')

      //first char of s equals first char of p
      if(firstMatch){
        // p contains ".*" at beginning.
        if(p.length>=2 && p.charAt(0).equals('.') && p.charAt(1).equals('*')) { matched = isMatch("", p.substring(2)) }
        // if second char of p is *, compare s[1, ...] to p.
        else if(p.length>=2 && p.charAt(1).equals('*')){ matched = isMatch(s.substring(1), p) }
        // else compare s[1, ...] to p[1, ...].
        else { matched = isMatch(s.substring(1), p.substring(1)) }
      } else {
        if(p.length>=2 && p.charAt(1).equals('*')){
          matched = isMatch(s, p.substring(2))
        }
      }
    } else if(s.isEmpty && p.isEmpty){
      matched = true
    } else if(s.isEmpty){
      if(p.length>=2 && p.charAt(1).equals('*')){
        matched = isMatch("", p.substring(2))
      }
    } else if(p.isEmpty){
      matched = false
    }

    matched
  }
}
