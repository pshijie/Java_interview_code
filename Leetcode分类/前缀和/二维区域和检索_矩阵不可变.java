package 前缀和;


/**
 * @author psj
 * @date 2022/9/30 10:14
 * @File: 二维区域和检索_矩阵不可变.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 304
// https://leetcode.cn/problems/range-sum-query-2d-immutable/

// 假设矩阵为ABCD(左上角点为A，右下角为C),则S(ABCD)=S(OC)-S(OB)-S(OD)+S(OA)
// 其中S(OA)表示(0,0)到A点的矩形元素和
public class 二维区域和检索_矩阵不可变 {
    int[][] dp;  // dp[i][j]表示(0,0)到(i,j)形成的矩形元素和大小

    public 二维区域和检索_矩阵不可变(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // dp[i][j]是dp[i+1][j]和dp[i][j+1]重合的部分，说明是多加的，需要减去
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + matrix[i][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 这里与算dp[i][j]的过程是不同的
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
