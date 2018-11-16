public class ReverseBetween {
    public LinkedNode reverseBetween(LinkedNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        LinkedNode dummy = new LinkedNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        LinkedNode premNode = head;
        LinkedNode mNode = head.next;
        LinkedNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            LinkedNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;

        return dummy.next;
    }
}
