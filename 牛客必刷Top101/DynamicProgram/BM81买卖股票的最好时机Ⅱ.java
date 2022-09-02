package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/10 11:26
 * @File: BM81买卖股票的最好时机Ⅱ.java
 * @Software: IntelliJ IDEA
 */
public class BM81买卖股票的最好时机Ⅱ {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]表示第i+1天不持有股票的最大收益
        // dp[i][1]表示第i+1天持有股票的最大收益
        int[][] dp = new int[n][2];
        // 第一天不持有股票，收益为0
        dp[0][0] = 0;
        // 第一天持有股票,收益为-prices[0]
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 第i+1天未持有股票可以由两个状态转移:
            //    第i天也没有股票
            //    第i天有股票,然后在第i+1天卖了(即以第i+1天的价格计算)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i+1天持有股票可以由两个状态转移:
            //    第i天已经持有了股票
            //    第i天没有股票,然后在第i+1天买了(即以第i+1天的价格计算)
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        // dp[n-1][0]一定大于dp[n-1][1]
        return dp[n - 1][0];
    }
}
