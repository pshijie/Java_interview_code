package 前缀;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/10/2 10:42
 * @File: 和等于k的最长子数组长度.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 325
// https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/
// 给定一个数组nums和一个目标值k，找到和等于k的最长子数组长度

public class 和等于k的最长子数组长度 {
    // 1.奇数出每个索引的前缀和（sum保存前缀和，max存储最长数组长度）
    // 2.利用HashMap存储每个前缀和以及对应的索引，前缀和相同则存储最小的索引
    // 3.使用指针从子数组的尾部从后向前遍历，找map中是否存储key为sum[i]-k的索引，有就更新max
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        int[] sum = new int[len + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];  // 不包括当前元素
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);  // 存储第一次出现位置就是索引最小的位置
            }
        }
        // 从后向前遍历
        for (int i = len; i > max; i--) {
            if (map.containsKey(sum[i] - k)) {
                max = Math.max(max, i - map.get(sum[i] - k));
            }
        }
        return max;
    }
}
