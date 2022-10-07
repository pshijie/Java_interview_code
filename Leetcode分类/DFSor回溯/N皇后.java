package DFSor回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/7 10:46
 * @File: N皇后.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 50
// https://leetcode.cn/problems/n-queens/

public class N皇后 {
    // 遍历每一行的每一列，看能否放置皇后
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        dfs(n, 0, chessboard);
        return result;
    }

    private void dfs(int n, int row, char[][] chessboard) {
        // 如果遍历到第n行
        if (row == n) {
            result.add(Array2List(chessboard));
            return;
        }

        // 遍历当前行的每一列，看是否可以放置皇后
        for (int col = 0; col < n; col++) {
            if (isVaild(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                dfs(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isVaild(int row, int col, int n, char[][] chessboard) {
        // 判断当前要放置皇后的第col列是否放置过皇后
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 判断chessborad[row][col]的左上角位置是否放置过皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 判断chessborad[row][col]的右上角位置是否放置过皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 将char类型的二维数组转换为List集合
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

}
