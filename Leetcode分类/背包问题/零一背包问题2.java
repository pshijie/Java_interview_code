package 背包问题;

/**
 * @author psj
 * @date 2022/10/16 10:14
 * @File: 零一背包问题2.java
 * @Software: IntelliJ IDEA
 */
// lintcode92
// https://www.lintcode.com/problem/92/

public class 零一背包问题2 {
    // 和零一背包不同点在于dp[i][j]的含义不是最大价值而是最大实际重量
    // 方法1：二维数组
    public int backPack_twodim(int m, int[] a) {
        // dp[i][j]表示选择前i个物品，容量为j的背包最大实际容量
        int[][] dp = new int[a.length + 1][m + 1];
        /*
        dp[i][j]表示选择前i个物品，背包容量为j的情况下，背包中物品的最大实际容量
        对于dp[i][j]有两种情况：
            1. 不选择当前的第i件物品，则dp[i][j] = dp[i-1][j]
            2. 选择当前的第i件物品，则能装入的物品最大价值=当前物品的价值+背包剩余容量在只能选前i-1件物品的情况下的最大价值
               dp[i][j] = dp[i-1][j-v[i]] + w[i]
        */
        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= a[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a[i - 1]] + a[i - 1]);
                } else {
                    // 容量不足以装下当前物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[a.length][m];
    }

    // 方法2：降维，因为二维数组中第一维度都是i-1，可以省略
    public int backPack(int m, int[] a) {
        // dp[i]表示背包容量为i的情况下，最大的装载量
        int[] dp = new int[m + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = m; j >= a[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - a[i]] + a[i]);
            }
        }
        return dp[m];
    }
}
