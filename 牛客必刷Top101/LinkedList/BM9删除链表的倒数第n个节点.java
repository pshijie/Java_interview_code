package LinkedList;

/**
 * @author psj
 * @date 2022/7/13 9:24
 * @File: BM9删除链表的倒数第n个节点.java
 * @Software: IntelliJ IDEA
 */
public class BM9删除链表的倒数第n个节点 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode delete = head;
        ListNode move = head;
        for (int i = 0; i < n; i++) {
            if (move != null) {
                move = move.next;
            } else {
                return null;
            }
        }
        while (move != null) {
            move = move.next;
            pre = pre.next;
            delete = delete.next;
        }
        pre.next = delete.next;
        return dummy.next;
    }
}
