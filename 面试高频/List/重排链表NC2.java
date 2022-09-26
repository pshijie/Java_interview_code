package List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/9/26 10:47
 * @File: 重排链表NC2.java
 * @Software: IntelliJ IDEA
 */
public class 重排链表NC2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            list.get(r).next = list.get(l);
            r--;
        }

        list.get(l).next = null;
    }
}
