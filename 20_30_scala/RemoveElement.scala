object RemoveElement {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var pointer = 0
    for(i <- nums.indices){
      if(nums(i) != `val`){
        nums.update(pointer, nums(i))
        pointer += 1
      }
    }
    pointer
  }
}
