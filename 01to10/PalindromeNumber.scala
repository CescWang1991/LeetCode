/**
  * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
  */
object PalindromeNumber {
  def main(args: Array[String]): Unit = {
    val num = 1234321
    println(isPalindrome(num))
  }

  def isPalindrome(x: Int): Boolean = {
    var isPal = false
    var y = x
    if(y <0 || (y % 10 == 0 && y != 0 )){
      isPal = false
    }
    var reversed = 0
    while(y > reversed){
      reversed = reversed * 10 + y % 10
      y /= 10
    }
    if(y == reversed || y == reversed / 10){ isPal = true }

    isPal
  }
}
