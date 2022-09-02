package LinkedList;
/**
 * @author psj
 * @date 2022/7/10 9:55
 * @File: LinkedList.BM1反转链表.java
 * @Software: IntelliJ IDEA
 */
public class BM1反转链表 {
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

//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode newHead = ReverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return newHead;
    }
}
