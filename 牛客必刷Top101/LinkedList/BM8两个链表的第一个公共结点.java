package LinkedList;

/**
 * @author psj
 * @date 2022/7/13 9:35
 * @File: BM8两个链表的第一个公共结点.java
 * @Software: IntelliJ IDEA
 */
public class BM8两个链表的第一个公共结点 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = pHead2;
            }
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = pHead1;
            }
        }
        return p1;
    }
}
