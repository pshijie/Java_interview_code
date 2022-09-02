package LinkedList;

/**
 * @author psj
 * @date 2022/7/12 9:33
 * @File: LinkedList.BM4合并两个排序的链表.java
 * @Software: IntelliJ IDEA
 */
public class BM4合并两个排序的链表 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode move = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                move.next = list1;
                list1 = list1.next;
            } else {
                move.next = list2;
                list2 = list2.next;
            }
            move = move.next;
        }
        if (list1 != null) {
            move.next = list1;
        }
        if (list2 != null) {
            move.next = list2;
        }
        return dummy.next;
    }
}
