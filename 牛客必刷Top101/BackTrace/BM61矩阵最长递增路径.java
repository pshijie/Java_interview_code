package BackTrace;

/**
 * @author psj
 * @date 2022/8/2 11:21
 * @File: BM61矩阵最长递增路径.java
 * @Software: IntelliJ IDEA
 */
public class BM61矩阵最长递增路径 {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int result;
    int m, n;

    public int solve(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }

        m = matrix.length;
        n = matrix[0].length;
        result = Integer.MIN_VALUE;
        // 记录在(i,j)处的最长递增路径
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(matrix, i, j, 0);
            }
        }
        return result;  // 返回的并不是dp[m][n]，因为最长递增路径并不一定是到右下角
    }

    // len表示移到到当前位置(i,j)时的最长递增路径长度
    public void solve(int[][] matrix, int i, int j, int len) {
        len++;
        if (len > result) {
            result = len;
        }
        for (int[] dir : dirs) {
            int i_next = i + dir[0], j_next = j + dir[1];
            if (i_next < 0 || i_next >= n || j_next < 0 || j_next >= m)
                continue;
            if (matrix[i_next][j_next] <= matrix[i][j])
                continue;
            solve(matrix, i_next, j_next, len);
        }
    }
}
