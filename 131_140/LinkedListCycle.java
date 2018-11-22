/**
 * 141. Linked List Cycle
 * 142. Linked List Cycle II
 */
public class LinkedListCycle {
    // 快慢指针，慢指针每次走一步，快指针每次走两步，当快指针和慢指针相同时，则证明有环。
    // 若出现NullPointerException，则说明链表存在null，则无环。
    public boolean hasCycle(ListNode head) {
        try {
            ListNode slow = head;
            ListNode fast = head;
            while (true) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
    }
    // fast：x+ay+m，slow：x+by+m  (a > b), x+ay+m = 2(x+by+m), 整理得x+m = (a-2b)y
    // 相遇时的位置(m)再前进x步，正好是y的整倍数即整圈。
    public ListNode detectCycle(ListNode head) {
        try {
            ListNode slow = head;
            ListNode fast = head;
            ListNode curr = new ListNode(0);
            while (true) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }
            fast = head;
            while(true) {
                fast = fast.next;
                slow = slow.next;
                if (slow == fast) {
                    return slow;
                }
            }
        } catch (NullPointerException e) {
            return null;
        }
    }
}
