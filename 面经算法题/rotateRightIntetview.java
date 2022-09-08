/**
 * @author psj
 * @date 2022/8/22 21:00
 * @File: rotateRightIntetview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 61
public class rotateRightIntetview {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode tail = null;
        ListNode temp = head;
        while (temp != null) {
            len++;
            tail = temp;
            temp = temp.next;
        }

        k = k % len;

        temp = head;
        for (int i = 0; i < len - k - 1; i++) {
            temp = temp.next;
        }

        tail.next = head;

        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }
}
