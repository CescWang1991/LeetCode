/*
保存两个链，一个存放小于target的数，另一个则相反，最后合并两个链表
 */

object PartitionList {
  def partition(head: ListNode, x: Int): ListNode = {
    var node = head
    val dummyLess, dummyLarge = new ListNode(0)
    var less = dummyLess
    var large = dummyLarge
    while(node != null){
      if(node.x < x){
        less.next = node
        less = node
      } else{
        large.next = node
        large = node
      }
      node = node.next
    }
    less.next = dummyLarge.next
    large.next = null

    dummyLess.next
  }
}
