package LinkedList;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/7/12 9:40
 * @File: LinkedList.BM5合并k个已排序的链表.java
 * @Software: IntelliJ IDEA
 */
public class BM5合并k个已排序的链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 小顶堆
        Queue<ListNode> pq = new PriorityQueue<>((a1, a2) -> a1.val - a2.val);
        // 将所有链表的第一个节点放入堆中(每个链表其实就是用第一个节点表示)
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null){
                pq.add(lists.get(i));
            }
        }
        // 创建dummy和move
        ListNode dummy = new ListNode(-1);
        ListNode move = dummy;
        // move开始遍历堆
        while(!pq.isEmpty()){
            // 找出堆小最小节点并将其从堆中移除(即获得了该节点所在链表)
            ListNode minNode = pq.poll();
            // 相当于将该最小元素加入到结果链表中
            move.next = minNode;
            move = move.next;
            // 将该节点所在链表的后续元素加入到堆中(其实就保存该链表的下一个元素)
            if(minNode.next != null){
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
}
