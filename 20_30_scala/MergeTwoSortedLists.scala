object MergeTwoSortedLists {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = new ListNode(0)
    var node = new ListNode(0)
    var left = l1
    var right = l2
    dummy.next = node

    while(left != null || right != null){
      if(left != null && right != null){
        if(left.x <= right.x){
          node.next = new ListNode(left.x)
          left = left.next
        } else {
          node.next = new ListNode(right.x)
          right = right.next
        }
      } else if(left == null){
        node.next = new ListNode(right.x)
        right = right.next
      } else{
        node.next = new ListNode(left.x)
        left = left.next
      }
      node = node.next
    }

    dummy.next.next
  }
}
