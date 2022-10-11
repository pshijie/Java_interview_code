package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/11 10:57
 * @File: 矩阵中的最长递增路径.java
 * @Software: IntelliJ IDEA
 */
// Leetcode329
// https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/

public class 矩阵中的最长递增路径 {
    // 需要方向思考：如果当前点大于四个方向中的某个点，则说明当前点可以往这方向前进(反方向走不就恰好形成从小到大的路径吗)
    public int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int row, col;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        row = matrix.length;
        col = matrix[0].length;
        int[][] memo = new int[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, dfs(matrix, i, j, memo));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        // 因为每个位置的最长递增路径是固定的(属于最值问题)，所以可以直接从memo取出
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        // 当前位置属于路径中的一部分
        memo[r][c]++;

        for (int[] d : dir) {
            int newR = r + d[0];
            int newC = c + d[1];
            // 下个前进的点在合理的位置(既然可以到下个点，则说明下个点反方向前进就到当前点)
            if (newR >= 0 && newR < row && newC >= 0 && newC < col) {
                if (matrix[newR][newC] < matrix[r][c]) {
                    memo[r][c] = Math.max(memo[r][c], dfs(matrix, newR, newC, memo) + 1);
                }
            }
        }

        return memo[r][c];
    }
}
