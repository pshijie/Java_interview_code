package StackQueue;

import java.util.*;

/**
 * @author psj
 * @date 2022/7/24 9:50
 * @File: BM45滑动窗口的最大值.java
 * @Software: IntelliJ IDEA
 */
public class BM45滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        // 窗口大于数组长度的时返回空
        if (size <= num.length && size != 0) {
            // 双向队列,保存的是数组中的下标，不是值
            Deque<Integer> dq = new ArrayDeque<>();
            // 先遍历一个窗口
            for (int i = 0; i < size; i++) {
                //去掉比自己先进队列的小于自己的值
                while (!dq.isEmpty() && num[dq.peekLast()] < num[i])
                    dq.pollLast();
                dq.add(i);
            }
            // 遍历后续数组元素
            for (int i = size; i < num.length; i++) {
                // 取窗口内的最大值
                res.add(num[dq.peekFirst()]);
                while (!dq.isEmpty() && dq.peekFirst() < (i - size + 1))
                    // 窗口中保存的值的下标已经不属于该窗口了
                    dq.pollFirst();
                // 加入新的值前，去掉比自己先进队列的小于自己的值
                while (!dq.isEmpty() && num[dq.peekLast()] < num[i])
                    dq.pollLast();
                dq.add(i);
            }
            res.add(num[dq.pollFirst()]);
        }
        return res;
    }
}
