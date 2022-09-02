package BackTrace;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/8/1 12:36
 * @File: BM59N皇后问题.java
 * @Software: IntelliJ IDEA
 */
public class BM59N皇后问题 {
    int result;

    public int Nqueen(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backTrace(board, n, 0);
        return result;
    }

    public void backTrace(char[][] board, int n, int row) {
        if (row == board.length) {
            result++;
            return;
        }
        // 当前处于第row行,需要遍历该行的所有列是否符合要求
        for (int col = 0; col < n; col++) {
            if (!isVaild(board, n, row, col)) {
                continue;
            }

            board[row][col] = 'Q';

            backTrace(board, n, row + 1);

            board[row][col] = '.';
        }

    }

    // row表示当前行,col表示当前列
    public boolean isVaild(char[][] board, int n, int row, int col) {
        // 检查上方向
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
