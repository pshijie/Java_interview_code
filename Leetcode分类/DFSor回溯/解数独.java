package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/10 11:52
 * @File: 解数独.java
 * @Software: IntelliJ IDEA
 */
// Leetcode37
// https://leetcode.cn/problems/sudoku-solver/

public class 解数独 {
    // 和解数独方法一致，思路更清晰
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }
    private boolean backTracking(char[][] board){
        for (int i = 0; i < 9; i++){ // 遍历行
            for (int j = 0; j < 9; j++){ // 遍历列
                if (board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){  // 尝试在当前位置放置1-9
                    if (isValid(i, j, k, board)){
                        board[i][j] = k;//放置数字
                        if (backTracking(board)){  // 合法返回ture
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;  // 1-9的数字都不合法，返回false
            }
        }
        return true;  // 全部可能性都尝试完成 返回true说明有解
    }


    private boolean isValid(int row, int col, char val, char[][] board){
        // 当前行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 当前列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 3*3中的元素是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
