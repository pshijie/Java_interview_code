package List;

/**
 * @author psj
 * @date 2022/9/25 9:41
 * @File: 链表的奇偶重排NC133.java
 * @Software: IntelliJ IDEA
 */
public class 链表的奇偶重排NC133 {
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
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;
        return head;
    }
}
