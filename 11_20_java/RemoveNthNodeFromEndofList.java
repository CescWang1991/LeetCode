public class RemoveNthNodeFromEndofList {
    public LinkedNode removeNthFromEnd(LinkedNode head, int n) {
        int length = 0;
        LinkedNode dummy = new LinkedNode(0);
        dummy.next = head;
        LinkedNode node = head;
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
