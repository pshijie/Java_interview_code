package 前缀和;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/10/1 10:28
 * @File: 和为K的子数组.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 560
// https://leetcode.cn/problems/subarray-sum-equals-k/


public class 和为K的子数组 {
    // 方法1:前缀和+hash优化
    // 计算当前数组的前缀和后，查看有多少个前缀和等于preSum-k
    // 因为满足preSum - (preSum - k) == k的区间个数是题目的解
    // 所以前缀和为preSum - k的数量即为连续子数组和为k的数量
    public int subarraySum_hashMap(int[] nums, int k) {
        // key:前缀和 value：
        HashMap<Integer, Integer> preSumFreq = new HashMap<>();
        // 下标为0的元素，前缀和为0
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            // 计算前缀和，可以不使用数组存储
            preSum += num;
            // 获取前缀和为preSum-k的个数
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            // 更新每个前缀和出现的次数
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    // 方法2:暴力
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;  // 记录nums[right...len-1]的前缀和(包括当前元素)
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
