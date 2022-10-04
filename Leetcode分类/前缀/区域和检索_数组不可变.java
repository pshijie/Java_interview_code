package 前缀;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/9/30 10:01
 * @File: 区域和检索_数组不可变.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 303
// https://leetcode.cn/problems/range-sum-query-immutable/

// 使用最简单的前缀和即可
public class 区域和检索_数组不可变 {
    private int[] sum;

    public 区域和检索_数组不可变(int[] nums) {
        sum = Arrays.copyOf(nums, nums.length);
        // 直接在原数组上改变即可
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return (left == 0) ? sum[right] : (sum[right] - sum[left - 1]);
    }
}
