package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/10 11:35
 * @File: BM82买卖股票的最好时机Ⅲ.java
 * @Software: IntelliJ IDEA
 */
public class BM82买卖股票的最好时机Ⅲ {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j][0]表示第i+1天截止时，当最多能进行j次交易，并且手上没有股票时的最大利润
        // dp[i][j][1]表示第i+1天截止时，当最多能进行j次交易，并且手上有股票时的最大利润
        int[][][] dp = new int[n][3][2];
        // base case(在Ⅰ和Ⅱ中,转移方程中第二维可以省略,这里不行)
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                // 第i+1天未持有股票可以由两个状态转移:
                //    第i天也没有股票
                //    第i天有股票,然后在第i+1天卖了(即以第i+1天的价格计算),交易次数是不变的
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                // 第i+1天持有股票可以由两个状态转移:
                //    第i天也有股票
                //    第i天没有股票,然后在第i+1天买了(即以第i+1天的价格计算),交易次数增加
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // dp[n-1][2][0]肯定大于dp[n-1][2][1]、dp[n-1][1][1]...
        return dp[n - 1][2][0];
    }
}
