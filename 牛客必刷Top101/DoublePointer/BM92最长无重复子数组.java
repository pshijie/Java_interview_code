package DoublePointer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author psj
 * @date 2022/8/13 11:34
 * @File: BM92最长无重复子数组.java
 * @Software: IntelliJ IDEA
 */
public class BM92最长无重复子数组 {
    public int maxLength(int[] arr) {
        int left = 0, right = 0;
        int result = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        while (right < arr.length) {
            // 如果集合中包含当前元素，则缩小窗口
            if (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            } else {
                set.add(arr[right]);
                right++;
                result = Math.max(result, set.size());
            }

        }
        return result;
    }
}
