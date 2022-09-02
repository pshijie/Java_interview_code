package StackQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author psj
 * @date 2022/7/24 10:14
 * @File: BM46最小的K个数.java
 * @Software: IntelliJ IDEA
 */
public class BM46最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k == 0 || input.length == 0)
            return result;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < k; i++) {
            pq.offer(input[i]);
        }
        // *将剩余数组中较小的元素入大根堆
        // 之所以要大根堆是因为如果是小根堆，可能初始堆的时候堆顶已经是数组最小值,后续元素根本加不进来
        for (int i = k; i < input.length; i++) {
            if (input[i] < pq.peek()) {
                pq.poll();
                pq.offer(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }
        return result;
    }
}
