object SearchSortedArray {

  def main(args: Array[String]): Unit = {
    val nums = Array[Int](3,4,5,1,2)
    val target = 1
    println(search(nums, target))
  }

  def search(nums: Array[Int], target: Int): Boolean = {
    if(nums.length <= 0){ return false }
    if(target >= nums(0)){
      for(i <- nums.indices){
        if(target == nums(i)){ return true}
        else if(target < nums(i)){ return false }
      }
    } else {
      for(i <- nums.indices.reverse){
        if(target == nums(i)){ return true}
        else if(target > nums(i)){ return false }
      }
    }

    false
  }
}
