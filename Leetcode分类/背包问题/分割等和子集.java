package 背包问题;

/**
 * @author psj
 * @date 2022/10/16 10:58
 * @File: 分割等和子集.java
 * @Software: IntelliJ IDEA
 */
// Leetcode416
// https://leetcode.cn/problems/partition-equal-subset-sum/

public class 分割等和子集 {
    // 将问题转换为是否可以从输入数组中选出一些数，这些数的和是否等于整个数组和的一半
    // 方法1：二维数组
    public boolean canPartition_twodim(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // dp[i][j]表示从nums[0...i]中挑选一些数，存在一个方式将容量为j的背包装满
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];

        // 无法均分为两份
        if (sum % 2 != 0) {
            return false;
        }

        // 当目标容量为0时，直接不选择即可，所以一定为true
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        // 不选择物品要装到目标容量i肯定不行
        for (int i = 0; i <= sum / 2; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                // 如果目标容量不足以装下nums[i-1]，则不选择该数
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 如果目标容量可以装下nums[i-1]，可以选择装也可以选择不装
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        // 子集可以为空，所以即使将所有数组的元素分为一个子集，另一个为空也可
        return dp[nums.length][sum / 2];
    }

    // 方法2：一维数组
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // dp[i]表示存在一个方式将容量为i的背包装满
        boolean[] dp = new boolean[sum / 2 + 1];

        // 无法均分为两份
        if (sum % 2 != 0) {
            return false;
        }

        // 目标容量为0时肯定可以划分，不选择数字即可
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                // 可选择也可不选择
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[sum / 2];
    }
}
