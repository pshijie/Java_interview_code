package DFSor回溯;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/10/7 11:11
 * @File: N皇后Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 52
// https://leetcode.cn/problems/n-queens-ii/

public class N皇后Ⅱ {
    // 和N皇后解法一致,改为计算数量而已
    int result = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        dfs(n, 0, chessboard);
        return result;
    }

    private void dfs(int n, int row, char[][] chessboard) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                dfs(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
