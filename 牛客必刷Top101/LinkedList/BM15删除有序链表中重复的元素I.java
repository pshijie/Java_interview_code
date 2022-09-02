package LinkedList;

/**
 * @author psj
 * @date 2022/7/15 9:03
 * @File: BM15删除有序链表中重复的元素I.java
 * @Software: IntelliJ IDEA
 */
public class BM15删除有序链表中重复的元素I {
    class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
