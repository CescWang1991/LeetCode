object DeleteDuplicates {

  def main(args: Array[String]): Unit = {

  }

  def deleteDuplicates(head: ListNode): ListNode = {
    var curr = head
    while(curr != null && curr.next != null){
      if(curr.x == curr.next.x){
        curr.next = curr.next.next
      } else {
        curr = curr.next
      }
    }

    head
  }
}
