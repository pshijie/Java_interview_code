package Array;

/**
 * @author psj
 * @date 2022/9/25 10:28
 * @File: 顺时针旋转矩阵NC18.java
 * @Software: IntelliJ IDEA
 */
public class 顺时针旋转矩阵NC18 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        int length = mat.length;
        // 先上下交换
        for (int i = 0; i < length / 2; i++) {
            int temp[] = mat[i];
            mat[i] = mat[length - i - 1];
            mat[length - i - 1] = temp;
        }
        // 再按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }
}
