object GrayCode {
  def main(args: Array[String]): Unit = {
    val n = 4
    println(grayCode(n))
  }

  def grayCode(n: Int): List[Int] = {
    if(n == 0){ return List(0) }
    if(n == 1){ return List(0,1) }
    val former = GrayCode.grayCode(n-1)
    val current = (former.map(_.toBinaryString.concat("0")) ++ former.reverse.map(_.toBinaryString.concat("1")))
        .map(str => Integer.parseInt(str, 2))

    current
  }
}
