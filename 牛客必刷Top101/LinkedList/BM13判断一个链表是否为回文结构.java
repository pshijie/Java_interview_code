package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/14 9:16
 * @File: BM13判断一个链表是否为回文结构.java
 * @Software: IntelliJ IDEA
 */
public class BM13判断一个链表是否为回文结构 {
    class ListNode {
        int val;
        ListNode next = null;
    }

    public boolean isPail(ListNode head) {
// 方法1:复制
//         ArrayList<Integer> arr1 = new ArrayList<>();
//         while(head != null){
//             arr1.add(head.val);
//             head = head.next;
//         }
//         List<Integer> arr2 = new ArrayList<>();
//         arr2 = (ArrayList<Integer>)arr1.clone();
//         Collections.reverse(arr2);
//         for(int i = 0; i < arr2.size(); i++){
//             int a = arr1.get(i);
//             int b = arr2.get(i);
//             if(a != b){
//                 return false;
//             }
//         }
//         return true;

        // 方法2:栈
        ListNode move = head;
        Stack<Integer> s = new Stack<>();
        while (move != null) {
            s.push(move.val);
            move = move.next;
        }
        move = head;
        while (!s.isEmpty()) {
            if (s.pop() != move.val) {
                return false;
            }
            move = move.next;
        }
        return true;
    }

}
