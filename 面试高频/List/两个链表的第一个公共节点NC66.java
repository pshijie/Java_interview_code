package List;

/**
 * @author psj
 * @date 2022/9/9 10:42
 * @File: 两个链表的第一个公共节点NC66.java
 * @Software: IntelliJ IDEA
 */
public class 两个链表的第一个公共节点NC66 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != l2) {
            if (l1 == null) {
                l1 = pHead2;
            }else {
                l1 = l1.next;
            }
            if (l2 == null) {
                l2 = pHead1;
            }else {
                l2 = l2.next;
            }
        }
        return l1;
    }
}
