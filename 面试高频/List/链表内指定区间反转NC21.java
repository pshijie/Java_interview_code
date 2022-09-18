package List;

/**
 * @author psj
 * @date 2022/9/18 10:02
 * @File: 链表内指定区间反转NC21.java
 * @Software: IntelliJ IDEA
 */
public class 链表内指定区间反转NC21 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 截出子链表
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode right = pre;
        for (int i = 0; i < n - m + 1; i++) {
            right = right.next;
        }


        ListNode left = pre.next;
        ListNode cur = right.next;

        pre.next = null;
        right.next = null;

        // ------------------------

        reverse(left);
        pre.next = right;
        left.next = cur;

        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        if (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
