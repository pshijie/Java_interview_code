package StackQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author psj
 * @date 2022/9/12 9:37
 * @File: 合并k个已排序的链表NC51.java
 * @Software: IntelliJ IDEA
 */
public class 合并k个已排序的链表NC51 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode move = dummy;
        while (!pq.isEmpty()) {
            ListNode curNode = pq.poll();
            if (curNode.next != null) {
                pq.add(curNode.next);
            }
            curNode.next = null;
            move.next = curNode;
            move = move.next;
        }
        return dummy.next;
    }
}
