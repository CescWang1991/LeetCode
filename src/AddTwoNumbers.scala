class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
  * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
  *
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  */

object AddTwoNumbers {
  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(2)
    l1.next = new ListNode(4)
    l1.next.next = new ListNode(3)
    val l2 = new ListNode(5)
    l2.next = new ListNode(6)
    l2.next.next = new ListNode(4)
    println(addTwoNumbers(l1, l2).next.x)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var sum: Int = 0
    var carry: Int = 0
    var head: ListNode = null
    // set head of output
    if(l1 != null && l2 != null){
      sum = l1.x + l2.x
      carry = sum / 10
      head = new ListNode(sum % 10)
    }
    else {
      head = null
    }

    // set next node iterally
    var p: ListNode = l1.next
    var q: ListNode = l2.next
    var rest = head
    while(p != null && q != null){
      sum = p.x + q.x + carry
      carry = sum / 10
      rest.next = new ListNode(sum % 10)
      rest = rest.next
      p = p.next
      q = q.next
    }
    while(p != null){
      sum = p.x + carry
      carry = sum / 10
      rest.next = new ListNode(sum % 10)
      rest = rest.next
      p = p.next
    }
    while(q != null){
      sum = q.x + carry
      carry = sum / 10
      rest.next = new ListNode(sum % 10)
      rest = rest.next
      q = q.next
    }
    if(carry != 0){
      rest.next = new ListNode(1)
    }
    head
  }
}
