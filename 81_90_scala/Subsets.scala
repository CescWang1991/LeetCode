object Subsets {
  def main(args: Array[String]): Unit = {
    println(subsetsWithDup(Array(4,4,4,1,4)))
  }

  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    if(nums.length == 0){ return List(List.empty) }
    val lists = new collection.mutable.ListBuffer[List[Int]]
    val dynamic = new collection.mutable.ArrayBuffer[Int]
    nums.foreach(dynamic.append(_))

    while(dynamic.nonEmpty){
      val term = dynamic.last
      dynamic.remove(dynamic.length-1)
      Subsets.subsetsWithDup(dynamic.toArray).foreach { list =>
        lists.append(list)
        val temp = list :+ term
        lists.append(temp.sorted)
      }
    }
    lists.distinct.toList
  }
}
