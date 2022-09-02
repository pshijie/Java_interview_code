package LinkedList;

/**
 * @author psj
 * @date 2022/7/12 9:14
 * @File: LinkedList.BM3链表中的节点每k个一组翻转.java
 * @Software: IntelliJ IDEA
 */
public class BM3链表中的节点每k个一组翻转 {
    class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // tail表示每次需要翻转的子链表尾部的下一个节点(即下一个需要翻转的子链表头节点)
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // 如果当前需要翻转的子链表不足k个节点,则直接返回
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode pre = null;
        ListNode cur = head;
        // 和反转链表一题类似
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时的head变为当前翻转后的子链表尾部，需要指向下个翻转后链表的头节点
        head.next = reverseKGroup(tail, k);
        return pre;
    }
}
