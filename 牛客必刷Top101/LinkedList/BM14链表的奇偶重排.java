package LinkedList;

/**
 * @author psj
 * @date 2022/7/14 9:39
 * @File: BM14链表的奇偶重排.java
 * @Software: IntelliJ IDEA
 */
public class BM14链表的奇偶重排 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // 用于后续将奇数链表连接到偶数链表
        while (even != null && even.next != null) {
            // 交替将odd.next连接even.next,even.next连接odd.next
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
