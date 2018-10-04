object MergekSortedLists {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    var init: ListNode = null
    lists.foreach(ln => init = MergeTwoSortedLists.mergeTwoLists(init, ln))
    init
  }
}
