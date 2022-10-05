package 前缀;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/10/4 11:38
 * @File: 字母与数字.java
 * @Software: IntelliJ IDEA
 */
// 面试题17.05
// https://leetcode.cn/problems/find-longest-subarray-lcci/

public class 字母与数字 {
    // 把数字视为1，字母视为-1，计算某区间前缀和相等的情况
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int result = 0;
        int sum = 0;
        // left和right是为了后续取出区间的值
        int left = 0;
        int right = 0;
        // key:前缀和的值 value:该值第一次出现的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (isDigit(array[i].charAt(0))) {
                sum--;
            } else {
                sum++;
            }
            if (map.containsKey(sum)) {
                // 出现某个区间前缀和相等，则计算该区间的长度
                if (result < i - map.get(sum)) {
                    result = i - map.get(sum);
                    left = map.get(sum);
                    right = i;
                }
            } else {
                map.put(sum, i);
            }
        }

        if (right - left == n) {
            return array;
        }

        String[] ans = new String[right - left];
        int index = 0;
        for (int i = left + 1; i <= right; i++) {
            ans[index++] = array[i];
        }
        return ans;
    }

    boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
