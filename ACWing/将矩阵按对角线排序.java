import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/9/11 22:37
 * @File: 将矩阵按对角线排序.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1329
public class 将矩阵按对角线排序 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (m == 1 || n == 1) {
            return mat;
        }
        // 从左边界每个点开始遍历排序
        for (int i = 0; i < m; i++) {
            sortDiagonal(mat, i, 0);
        }
        // 从上边界每个点开始遍历排序
        for (int i = 0; i < n; i++) {
            sortDiagonal(mat, 0, i);
        }
        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        // 从左上角的点出发
        if (row == 0 && col == 0) {
            for (int i = 0; i < Math.min(m, n); i++) {
                list.add(mat[i][i]);
            }
            list.sort((a, b) -> {
                return a - b;
            });
            // 排好序后在赋值回去
            for (int i = 0; i < Math.min(m, n); i++) {
                mat[i][i] = list.get(i);
            }
        }
        // 从左边界出发
        if (row != 0 && col == 0) {
            for (int i = row, j = 0; i < m && j < n; i++, j++) {
                list.add(mat[i][j]);
            }
            list.sort((a, b) -> {
                return a - b;
            });
            for (int i = row, j = 0; i < m && j < n; i++, j++) {
                mat[i][j] = list.get(j);
            }
        }
        // 从上边界出发
        if (row == 0 && col != 0) {
            for (int i = 0, j = col; i < m && j < n; i++, j++) {
                list.add(mat[i][j]);
            }
            list.sort((a, b) -> {
                return a - b;
            });
            for (int i = 0, j = col; i < m && j < n; i++, j++) {
                mat[i][j] = list.get(i);
            }
        }
    }
}
