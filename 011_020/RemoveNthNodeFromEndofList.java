public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        if(length > 1){
            length = length + 1 - n;
            node = dummy;
            for(int i = 1; i < length; i++){
                node = node.next;
            }
            node.next = node.next.next;
        } else {
            dummy.next = null;
        }
        return dummy.next;
    }
}
