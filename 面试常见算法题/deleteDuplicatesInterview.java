/**
 * @author psj
 * @date 2022/8/21 16:46
 * @File: deleteDuplicatesInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode82
public class deleteDuplicatesInterview {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int num = cur.next.val;

                while (cur.next != null && cur.next.val == num){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
