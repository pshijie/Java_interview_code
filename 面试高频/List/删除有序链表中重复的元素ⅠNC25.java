package List;

import java.util.UUID;

/**
 * @author psj
 * @date 2022/9/26 11:00
 * @File: 删除有序链表中重复的元素ⅠNC25.java
 * @Software: IntelliJ IDEA
 */
public class 删除有序链表中重复的元素ⅠNC25 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return dummy.next;
    }
}
