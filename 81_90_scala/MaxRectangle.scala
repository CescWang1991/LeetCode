object MaxRectangle {
  def main(args: Array[String]): Unit = {
    val matrix = Array(
      Array('1','0','1','0','0'),
      Array('1','0','1','1','1'),
      Array('1','1','1','1','1'),
      Array('1','0','0','1','0'))
    println(maximalRectangle(matrix))
  }

  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    val row = matrix.length
    val col = matrix(0).length
    val dp = new Array[Array[Int]](row + 1)
    for(i <- dp.indices){
      dp(i) = new Array[Int](col + 1)
      dp(i)(0) = 0
    }
    for(j <- dp(0).indices){
      dp(0)(j) = 0
    }
    for(i <- matrix.indices){
      for(j <- matrix(0).indices){
        if(i == 0 && j == 0){
          dp(i+1)(j+1) = if(matrix(i)(j).equals('1')) 1 else 0
        } else if(i == 0) {
          dp(i+1)(j+1) = dp(i+1)(j) + (if(matrix(i)(j).equals('1')) dp(i+1)(j)-dp(i+1)(j-1) else 0)
        } else if(j == 0) {
          dp(i+1)(j+1) = dp(i)(j+1) + (if(matrix(i)(j).equals('1')) dp(i)(j+1)-dp(i-1)(j+1) else 0)
        } else {
          if(matrix(i)(j).equals('1')){
            if(dp(i+1)(j)>dp(i)(j) && dp(i)(j+1)>dp(i)(j)){
              dp(i+1)(j+1) = dp(i+1)(j) + dp(i)(j+1) - dp(i)(j) + 1
            } else if(dp(i+1)(j)>dp(i)(j)) {
              var bar = 0
              var k = j
              while(k >= 0 && matrix(i)(k) != '0'){
                bar += 1
                k -= 1
              }
              dp(i+1)(j+1) = Math.max(dp(i+1)(j), bar)
            } else if(dp(i)(j+1)>dp(i)(j)){
              var bar = 0
              var k = i
              while(k >= 0 && matrix(k)(j) != '0'){
                bar += 1
                k -= 1
              }
              dp(i+1)(j+1) = Math.max(dp(i)(j+1), bar)
            } else {
              dp(i+1)(j+1) = Math.max(dp(i+1)(j), dp(i)(j+1))
            }
          } else {
            dp(i+1)(j+1) = Math.max(dp(i+1)(j), dp(i)(j+1))
          }
        }
      }
    }
    dp.foreach(array => println(array.deep.mkString(",")))

    dp(row)(col)
  }
}
