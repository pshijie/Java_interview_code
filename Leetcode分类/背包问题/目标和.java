package 背包问题;

/**
 * @author psj
 * @date 2022/10/16 11:18
 * @File: 目标和.java
 * @Software: IntelliJ IDEA
 */
// Leetcode494
// https://leetcode.cn/problems/target-sum/

public class 目标和 {
    // 假设将nums分为子集A和B，分别表示分配了+和-的数，则存在以下关系：
    // sum(A) - sum(B) = target
    // sum(A) = target + sum(B)
    // sum(A) + sum(A) = target + sum(B) + sum(A) = target + sum(nums)
    // 原问题转换为nums存在几个子集A满足sum(A) = (target + sum(nums))/2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;  // 存储nums的总和
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        return subsets(nums, (sum + target) / 2);
    }

    public int subsets(int[] nums, int sum) {
        int n = nums.length;
        // dp[i][j]=k表示在前nums的前i个数中进行选择,目标和为j时最多有k种方式
        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // 可以理解为当前目标容量够装下当前物品
                if (j >= nums[i - 1]) {
                    // 可以选择不装和装
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    // 当前目标容量不够装下当前物品,只能不装
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
