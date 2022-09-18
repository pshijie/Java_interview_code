package List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author psj
 * @date 2022/9/17 9:30
 * @File: 判断一个链表是否为回文结构NC96.java
 * @Software: IntelliJ IDEA
 */
public class 判断一个链表是否为回文结构NC96 {
    class ListNode {
        int val;
        ListNode next = null;
    }

    public boolean isPail(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode move = head;
        while (move != null) {
            list.add(move.val);
            move = move.next;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
