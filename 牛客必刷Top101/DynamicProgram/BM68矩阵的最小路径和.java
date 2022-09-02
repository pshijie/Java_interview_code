package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/4 11:32
 * @File: BM68矩阵的最小路径和.java
 * @Software: IntelliJ IDEA
 */
public class BM68矩阵的最小路径和 {
    public int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j]表示从左上角到(i,j)的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
