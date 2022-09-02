package LinkedList;

/**
 * @author psj
 * @date 2022/7/10 11:20
 * @File: LinkedList.BM2链表内指定区间反转.java
 * @Software: IntelliJ IDEA
 */
public class BM2链表内指定区间反转 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            // 走到m的前一个节点
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }

            // 走到n节点
            ListNode rightNode = pre;
            for (int i = 0; i < n - m + 1; i++) {
                rightNode = rightNode.next;
            }

            // 截取出一个子链表
            ListNode leftNode = pre.next;
            ListNode cur = rightNode.next;
            pre.next = null;
            rightNode.next = null;

            // 反转截取部分的链表
            reverseList(leftNode);

            // 将反转后的链表接回原链表
            pre.next = rightNode;
            leftNode.next = cur;

            return dummy.next;
        }
    }

    public void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
