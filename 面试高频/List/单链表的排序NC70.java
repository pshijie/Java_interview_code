package List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author psj
 * @date 2022/9/13 11:06
 * @File: 单链表的排序NC70.java
 * @Software: IntelliJ IDEA
 */
public class 单链表的排序NC70 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortInList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode move = head;
        while (move != null) {
            list.add(move.val);
            move = move.next;
        }
        move = head;
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            move.val = list.get(i);
            move = move.next;
        }

        return head;
    }
}
