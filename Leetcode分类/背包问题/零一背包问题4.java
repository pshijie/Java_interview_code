package 背包问题;

/**
 * @author psj
 * @date 2022/10/16 10:32
 * @File: 零一背包问题4.java
 * @Software: IntelliJ IDEA
 */
// lintcode800
// https://www.lintcode.com/problem/800/

public class 零一背包问题4 {
    // 将至少一所大学都未录取转换为一所都没录取的概率，然后使用1减去该概率即可
    // 方法1:一维数组
    public double backpackIX(int n, int[] prices, double[] probability) {
        // dp[i]表示花i万申请，但是一所都未录取的概率
        if (n == 0 || prices.length == 0) {
            return 0.0;
        }
        double[] dp = new double[n + 1];
        // 将录取概率该为未录取概率
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }
        // 因为后续的计算是求最小值，所以初始化为1.0
        for (int i = 0; i <= n; i++) {
            dp[i] = 1.0;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = n; j >= prices[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - prices[i]] * probability[i]);
            }
        }
        return 1 - dp[n];
    }

    // 方法2：二维数组
    public double backpackIX_twodim(int n, int[] prices, double[] probability) {
        if (n == 0 || prices.length == 0) {
            return 0.0;
        }
        int m = probability.length;
        // dp[i][j]表示对前i所学校花费j万未被录取的概率
        double[][] dp = new double[m + 1][n + 1];
        // 初始化为最大值1
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1.0;
        }
        // 将录取概率该为未录取概率
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j < prices[i - 1]) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - prices[i - 1]] * probability[i - 1]);
            }
        }

        return 1 - dp[m][n];
    }
}
