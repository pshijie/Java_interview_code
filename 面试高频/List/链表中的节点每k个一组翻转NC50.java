package List;

/**
 * @author psj
 * @date 2022/9/7 10:27
 * @File: 链表中的节点每k个一组翻转NC50.java
 * @Software: IntelliJ IDEA
 */
public class 链表中的节点每k个一组翻转NC50 {
    class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;  // *表示需要反转链表的下一个节点
        for (int i = 0; i < k; i++) {
            // 不足k个节点
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = reverseKGroup(tail, k);
        return pre;
    }
}
