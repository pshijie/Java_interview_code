package simulation;

/**
 * @author psj
 * @date 2022/8/15 12:40
 * @File: BM99顺时针旋转矩阵.java
 * @Software: IntelliJ IDEA
 */
public class BM99顺时针旋转矩阵 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // 1.先上下交换
        for (int i = 0; i < n / 2; i++) {
            int temp[] = mat[i];
            mat[i] = mat[n - i - 1];
            mat[n - i - 1] = temp;

        }
        // 2.再对角线交换
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }
}
