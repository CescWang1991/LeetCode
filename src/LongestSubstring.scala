/**
  * Given a string, find the length of the longest substring without repeating characters.
  */
object LongestSubstring {

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("jlygy"))
  }

  def lengthOfLongestSubstring(s: String): Int = {
    var longestLength = 0
    if(s.length != 0){
      var sub: String = s.substring(0,1)
      s.substring(1,s.length).foreach{ c =>
        if(!sub.contains(c)){
          sub = sub + c
        } else {
          sub = sub.substring(sub.indexOf(c)+1, sub.length) + c
        }
        val currentLength = sub.length
        if(longestLength==0 || currentLength>longestLength){
          longestLength = currentLength
        }
        if(longestLength == 0){
          longestLength = s.length
        }
      }
    }
    longestLength
  }
}
