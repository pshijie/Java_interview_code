package Array;

/**
 * @author psj
 * @date 2022/9/25 9:20
 * @File: 矩阵元素查找NC86.java
 * @Software: IntelliJ IDEA
 */
public class 矩阵元素查找NC86 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < mat[0].length) {
            if (mat[i][j] < x) {
                j++;
            } else if (mat[i][j] > x) {
                i--;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
