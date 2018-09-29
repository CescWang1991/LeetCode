/**
  * There are two sorted arrays nums1 and nums2 of size m and n respectively.
  * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  * You may assume nums1 and nums2 cannot be both empty.
  */
object MedianTwoArrays {

  def main(args: Array[String]): Unit = {
    val nums1: Array[Int] = Array.empty
    val nums2 = Array(7)
    println(findMedianSortedArrays(nums1, nums2))
  }

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val length = nums1.length + nums2.length
    println(length)
    var median: Double = 0.0
    var pos: Int = 0
    var num: Int = 0
    var i: Int = 0
    var j: Int = 0
    var end: Boolean = false
    while(!end){
      if(i <= nums1.length - 1 && j <= nums2.length - 1){
        if(nums1(i) <= nums2(j)){
          num = nums1(i)
          pos = pos + 1
          i = i + 1
        } else {
          num = nums2(j)
          pos = pos + 1
          j = j + 1
        }
      } else if(j == nums2.length) {
        num = nums1(i)
        pos = pos + 1
        i = i + 1
      } else if(i == nums1.length) {
        num = nums2(j)
        pos = pos + 1
        j = j + 1
      }

      if(length % 2 != 0){
        if(pos == (length + 1) / 2){
          median = num
          end = true
        }
      } else {
        if(pos == length / 2){
          median = num
        } else if(pos == length / 2 + 1){
          median = (median + num) / 2
          end = true
        }
      }
    }
    median
  }
}
