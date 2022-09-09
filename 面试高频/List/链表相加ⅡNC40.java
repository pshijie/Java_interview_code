package List;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

/**
 * @author psj
 * @date 2022/9/9 10:50
 * @File: 链表相加ⅡNC40.java
 * @Software: IntelliJ IDEA
 */
public class 链表相加ⅡNC40 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        ListNode r1 = reverse(head1);
        ListNode r2 = reverse(head2);
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (r1 != null || r2 != null) {
            sum += r1 != null ? r1.val : 0;
            sum += r2 != null ? r2.val : 0;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            sum /= 10;

            if (r1 != null) {
                r1 = r1.next;
            }
            if (r2 != null) {
                r2 = r2.next;
            }
        }

        if (sum != 0) {
            temp.next = new ListNode(sum);
        }
        return reverse(dummy.next);
    }

    ListNode reverse(ListNode head) {
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
