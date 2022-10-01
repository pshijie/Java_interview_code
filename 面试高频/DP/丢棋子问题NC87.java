package DP;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/10/1 9:19
 * @File: 丢棋子问题NC87.java
 * @Software: IntelliJ IDEA
 */
public class 丢棋子问题NC87 {
    int[][] memo;

    public int solve(int n, int k) {
        // memo[i][j]表示当前棋子数为k，需要测试的楼层为n时棋子不会摔碎的最高层数
        memo = new int[k + 1][n + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        if (memo[k][n] != -1) {
            return memo[k][n];
        }

        int result = Integer.MAX_VALUE;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            // 棋子碎了就将测试的楼层移到mid-1
            int broken = dp(k - 1, mid - 1);
            // 棋子没碎了就将测试的楼层移到n-mid
            int unBroken = dp(k, n - mid);
            if (broken > unBroken) {
                // 棋子碎了就往当前楼层下找
                hi = mid - 1;
                result = Math.min(result, broken + 1);
            } else {
                // 棋子没碎就往当前楼层上找
                lo = mid + 1;
                result = Math.min(result, unBroken + 1);
            }
        }
        memo[k][n] = result;
        return result;
    }
}
