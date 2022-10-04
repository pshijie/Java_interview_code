package 前缀;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/10/4 11:38
 * @File: 字母与数字.java
 * @Software: IntelliJ IDEA
 */
// 面试题17.05
// https://leetcode.cn/problems/find-longest-subarray-lcci/

public class 字母与数字 {
    // 把数字视为1，字母视为-1，计算某区间前缀和为0的情况，
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            char ch = array[i].charAt(0);
            if (ch >= 'A' && ch <= 'z') {
                arr[i] = -1;
            } else {
                arr[i] = 1;
            }
        }
        int left = 0;
        int right = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for (int i = 1; i < len; i++) {

            arr[i] += arr[i - 1];
            if (arr[i] == 0) {
                int size = right - left;
                if (i >= size) {
                    left = 0;
                    right = i;
                }
            } else if (map.containsKey(arr[i])) {
                int size = right - left;
                int temp = i - map.get(arr[i]) - 1;
                if ((temp > size) || (temp == size && map.get(arr[i]) < left)) {
                    left = map.get(arr[i]) + 1;
                    right = i;
                }
            } else {
                map.put(arr[i], i);
            }

        }
        return Arrays.copyOfRange(array, left, right + 1);
    }
}
