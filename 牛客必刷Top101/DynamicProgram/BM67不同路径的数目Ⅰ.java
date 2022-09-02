package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/4 11:27
 * @File: BM67不同路径的数目Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM67不同路径的数目Ⅰ {
    public int uniquePaths(int m, int n) {
        // dp[i][j]表示从起点到(i,j)的路径数量
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
