package LinkedList;

/**
 * @author psj
 * @date 2022/7/13 9:06
 * @File: BM8链表中倒数最后k个结点.java
 * @Software: IntelliJ IDEA
 */
public class BM8链表中倒数最后k个结点 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null || k == 0) {
            return null;
        }
        ListNode newHead = pHead;
        ListNode move = pHead;
        int moveCount = 0;
        for (int i = 0; i < k; i++) {
            if (move != null) {
                move = move.next;
                // 执行到该步说明链表的长度不足k
            } else {
                return null;
            }
        }
        while (move != null) {
            move = move.next;
            newHead = newHead.next;
        }
        return newHead;
    }
}
