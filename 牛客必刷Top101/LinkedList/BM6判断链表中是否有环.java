package LinkedList;

/**
 * @author psj
 * @date 2022/7/12 9:58
 * @File: LinkedList.BM6判断链表中是否有环.java
 * @Software: IntelliJ IDEA
 */
public class BM6判断链表中是否有环 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果相遇则有环
            if (fast == slow) {
                return true;
            }
        }
        // 如果fast移动到末尾则没有环
        return false;
    }
}
