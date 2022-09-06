package StackQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author psj
 * @date 2022/9/6 9:54
 * @File: 最小的K个数NC119.java
 * @Software: IntelliJ IDEA
 */
public class 最小的K个数NC119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (input == null || input.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (pq.peek() > input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
            pq.add(input[i]);
        }

        for (int num : pq) {
            result.add(num);
        }
        return result;

    }
}
