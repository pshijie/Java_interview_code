package List;

import java.util.List;

/**
 * @author psj
 * @date 2022/9/6 8:40
 * @File: 反转链表NC78.java
 * @Software: IntelliJ IDEA
 */
// 给定一个单链表的头结点pHead，长度为n，反转该链表后，返回新链表的表头
public class 反转链表NC78 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
