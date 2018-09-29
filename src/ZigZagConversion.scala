import scala.collection.mutable.ArrayBuffer

/**
  * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
  * P   A   H   N
  * A P L S I I G
  * Y   I   R
  * And then read line by line: "PAHNAPLSIIGYIR"
  */
object ZigZagConversion {

  def main(args: Array[String]): Unit = {
    val s = "A"
    val num = 1
    println(convert(s, num))
  }

  def convert(s: String, numRows: Int): String = {
    var output: String = ""
    val arr: Array[ArrayBuffer[Char]] = new Array(numRows)
    for(i <- 0 until numRows){
      arr(i) = new ArrayBuffer[Char]
    }
    var col = 0
    var row = 0
    val empty: Char = ' '
    s.foreach{c =>
      // 满行
      if(numRows > 1){
        if(col % (numRows - 1) == 0){
          arr(row) += c
          println("row: "+row+" array: "+arr(row))
          row += 1
          // change the column
          if(row == numRows){
            col += 1
            row = 0
          }
        }
        // 空行
        else {
          val offset = (numRows - 1) - col % (numRows - 1)
          for(row <- 0 until numRows){
            if(row == offset){
              arr(row) += c
            } else {
              arr(row) += empty
            }
            println("row: "+row+" array: "+arr(row))
          }
          row = 0
          col += 1
        }
      } else {
        arr(0) += c
      }
    }

    // put char to output string
    for(row <- 0 until numRows){
      val numCols = arr(row).length
      for(col <- 0 until numCols){
        if(!arr(row)(col).equals(' ')){
          output = output + arr(row)(col)
        }
      }
    }
    output
  }
}
