package 背包问题;

import java.util.Scanner;

/**
 * @author psj
 * @date 2022/10/7 11:27
 * @File: 零一背包问题.java
 * @Software: IntelliJ IDEA
 */
// Acwing 2
// https://www.acwing.com/problem/content/2/

public class 零一背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 多少件物品
        int V = sc.nextInt();  // 背包容量
        int[] v = new int[N+1];
        int[] w = new int[N+1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        System.out.println(maxValue(N, V, v, w));
    }

    private static int maxValue(int N, int V, int[] v, int[] w) {
        if (N == 0 || V == 0) {
            return 0;
        }

        /*
        dp[i][j]表示选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        对于dp[i][j]有两种情况：
            1. 不选择当前的第i件物品，则dp[i][j] = dp[i-1][j]
            2. 选择当前的第i件物品，则能装入的物品最大价值=当前物品的价值+背包剩余容量在只能选前i-1件物品的情况下的最大价值
               dp[i][j] = dp[i-1][j-v[i]] + w[i]
        */
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                // 背包容量足够装下当前物品(可以选择装入和不装入)
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }else {
                    // 容量不足以装下当前物品
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][V];
    }
}
