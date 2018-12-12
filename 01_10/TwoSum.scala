import scala.collection.mutable.HashMap

/**
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.
  *
  * Given nums = [2, 7, 11, 15], target = 9,
  *
  * Because nums[0] + nums[1] = 2 + 7 = 9,
  * return [0, 1].
  */
object TwoSum {

  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(2, 7, 11, 15)
    val target: Int = 9
    twoSum(nums, target).foreach(println(_))
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var a: Int = 0
    var b: Int = 0

    val map: HashMap[Int,Int] = new HashMap()
    for(i<-0 until nums.length){
      map.put(nums(i), i)
    }

    for(i<-0 until nums.length){
      val complement = target - nums(i)
      if(map.contains(complement) && complement != nums(i)){
        a = i
        b = map.get(complement).get
      }
    }
    Array(a, b)
  }
}
