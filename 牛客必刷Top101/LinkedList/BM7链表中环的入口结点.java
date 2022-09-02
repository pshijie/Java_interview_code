package LinkedList;

/**
 * @author psj
 * @date 2022/7/12 10:05
 * @File: BM7链表中环的入口结点.java
 * @Software: IntelliJ IDEA
 */
public class BM7链表中环的入口结点 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇就停止
            if (fast == slow) {
                break;
            }
        }
        // 还是需要判断是否有无环
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = pHead;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
