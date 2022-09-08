package List;

import java.util.List;

/**
 * @author psj
 * @date 2022/9/8 11:34
 * @File: 删除链表的倒数第n个节点NC53.java
 * @Software: IntelliJ IDEA
 */
public class 删除链表的倒数第n个节点NC53 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        ListNode pre = dummy;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        cur = head;
        for (int i = 0; i < len - n; i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        return dummy.next;
    }
}
