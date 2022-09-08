package List;

/**
 * @author psj
 * @date 2022/9/8 10:37
 * @File: 判断链表中是否有环NC4.java
 * @Software: IntelliJ IDEA
 */
public class 判断链表中是否有环NC4 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
