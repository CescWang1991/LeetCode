object RemoveDuplicatesFromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int = {
    var pointer = 0
    if(nums.length != 0){
      pointer = 1
      for(i <- 0 until nums.length - 1){
        if(nums(i) != nums(i+1)){
          nums.update(pointer, nums(i+1))
          pointer += 1
        }
      }
    }
    pointer
  }
}
