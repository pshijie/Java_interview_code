package LinkedList;

/**
 * @author psj
 * @date 2022/7/15 9:17
 * @File: BM16删除有序链表中重复的元素II.java
 * @Software: IntelliJ IDEA
 */
public class BM16删除有序链表中重复的元素II {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;  // *不是让其指向head,方便相同节点的移除

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int repeatNum = cur.next.val;
                // 将一连串相同的全部删除(即断开连接)
                while (cur.next != null && cur.next.val == repeatNum) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
