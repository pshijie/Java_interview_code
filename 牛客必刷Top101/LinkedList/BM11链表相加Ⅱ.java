package LinkedList;

/**
 * @author psj
 * @date 2022/7/13 9:44
 * @File: BM11链表相加Ⅱ.java
 * @Software: IntelliJ IDEA
 */
public class BM11链表相加Ⅱ {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        // 先将两个链表进行翻转
        ListNode rhead1 = reverse(head1);
        ListNode rhead2 = reverse(head2);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int sum = 0;
        while (rhead1 != null || rhead2 != null) {
            int a = rhead1 != null ? rhead1.val : 0;
            int b = rhead2 != null ? rhead2.val : 0;
            sum += (a + b);
            temp.next = new ListNode(sum % 10);
            sum /= 10;  // 相当于进位
            temp = temp.next;
            // 需要判断链表是否为空，再进行移动
            if (rhead1 != null) {
                rhead1 = rhead1.next;
            }
            if (rhead2 != null) {
                rhead2 = rhead2.next;
            }
        }
        // 如果最后还有一个进位，则需要再创建一个节点
        if (sum != 0) {
            temp.next = new ListNode(sum);
        }
        return reverse(dummy.next);
    }

    // 翻转链表
    public ListNode reverse(ListNode head) {
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
