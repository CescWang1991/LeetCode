import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Not solved
  */
object SubstringWithConcatenationOfAllWords {

  def main(args: Array[String]): Unit = {
    val s = "wordgoodgoodgoodbestword"
    val words = Array("good","word", "good", "best")
    findSubstring(s, words).foreach(println(_))
  }

  def findSubstring(s: String, words: Array[String]): List[Int] = {
    var length = 0
    val list = new ListBuffer[Int]()
    var subString = s
    var start = true

    if(words.nonEmpty){

      while(subString.indexOf(words(0)) != -1 && start){
        val indexAndLength = new ListBuffer[(Int, Int)]()
        var matched = true

        words.foreach(w =>
          if(subString.indexOf(w) != -1){
            val tup = (subString.indexOf(w), w.length)
            indexAndLength += tup
          } else{
            matched = false
            start = false
          })
        val sorted = indexAndLength.toList.sortBy(_._1)

        sorted.foreach(println(_))
        for(i <- 0 until sorted.length - 1){
          if(sorted(i+1)._1 - sorted(i)._1 != sorted(i)._2){
            matched = false
          }
        }
        println(matched)
        if(matched){
          list += (sorted.head._1 + length)
        }

        if(sorted.nonEmpty){
          subString = subString.substring(sorted.head._1+sorted.head._2)
          length = length + sorted.head._1+sorted.head._2
          println(length)
        }
      }
    }

    list.toList
  }
}
