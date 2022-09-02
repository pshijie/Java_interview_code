package LinkedList;

/**
 * @author psj
 * @date 2022/7/14 8:43
 * @File: BM12单链表的排序.java
 * @Software: IntelliJ IDEA
 */
public class BM12单链表的排序 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortInList(ListNode head) {
        // 方法1:链表复制
//         List<Integer> num = new ArrayList<>();
//         ListNode move = head;
//         while (move != null) {
//             num.add(move.val);
//             move = move.next;
//         }
//         move = head;  // move重新指向head，这样就不需要遍历数组的时候创建新节点
//         Collections.sort(num);
//         // 遍历num,将数组元素加入链表
//         for (int i = 0; i < num.size(); i++) {
//             move.val = num.get(i);
//             move = move.next;
//         }
//         return head;

        // 方法2:归并
        if (head == null || head.next == null) {
            return head;
        }
        // 三个指针用于将链表拆分为左右两个链表
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        // 断开连接
        left.next = null;
        return merge(sortInList(head), sortInList(mid));
    }

    // 合并两个有序链表
    ListNode merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val <= pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        if (pHead1 != null) {
            cur.next = pHead1;
        }
        if (pHead2 != null) {
            cur.next = pHead2;
        }

        return dummy.next;
    }
}
