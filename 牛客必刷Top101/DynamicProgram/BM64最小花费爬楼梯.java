package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/3 10:48
 * @File: BM64最小花费爬楼梯.java
 * @Software: IntelliJ IDEA
 */
public class BM64最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i]表示爬到第i阶楼梯需要的最小花费
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
