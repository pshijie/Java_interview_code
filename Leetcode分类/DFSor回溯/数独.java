package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/10 11:36
 * @File: 数独.java
 * @Software: IntelliJ IDEA
 */
// lintcode802
// https://www.lintcode.com/problem/802/

public class 数独 {
    // 数独的要求即在每一行/列/3*3矩阵中有1-9的数字，并且不重复
    public void solveSudoku(int[][] board) {
        dfs(board, 0, 0);
    }

    // 每一行的每一列开始穷举遍历
    private boolean dfs(int[][] board, int row, int col) {
        int m = 9, n = 9;
        // 越界，此时换到下一行开始遍历
        if (col == n) {
            return dfs(board, row + 1, 0);
        }

        // 遍历完所有格子
        if (row == m) {
            return true;
        }

        // 如果已经有数组，则不需要穷举
        if (board[row][col] != 0) {
            return dfs(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (!isVaild(board, row, col, i)) {
                continue;
            }
            board[row][col] = i;
            // 因为只需要一个可行解，找到了立刻结束
            if (dfs(board, row, col + 1)) {
                return true;
            }
            board[row][col] = 0;
        }
        return false;
    }

    private boolean isVaild(int[][] board, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            // 判断当前行是否等于val的数字
            if (board[row][i] == val) {
                return false;
            }
            // 判断当前列是否等于val的数字
            if (board[i][col] == val) {
                return false;
            }
            // 判断3*3矩阵是否等于val的数字
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == val)
                return false;
        }
        return true;
    }
}
