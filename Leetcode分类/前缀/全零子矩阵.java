package 前缀;

/**
 * @author psj
 * @date 2022/10/4 9:59
 * @File: 全零子矩阵.java
 * @Software: IntelliJ IDEA
 */
// 给定一个非负二维矩阵Matrix，元素均大于0，是否存在c行d列元素都为0的子矩阵

public class 全零子矩阵 {
    // 当子矩阵的元素和为0时，该子矩阵就为全0
    public boolean isZeroMatrix(int[][] Matrix, int c, int d) {
        int row = Matrix.length;
        int col = Matrix[0].length;
        int[][] prefixSum = new int[row + 1][col + 1];
        // 计算前缀和
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefixSum[i][j] = Matrix[i - 1][j - 1];
                // prefixSum[i-1][j-1]是prefixSum[i-1][j]和prefixSum[i][j-1]重合的部分，说明是多加的，需要减去
                prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        // 枚举子矩阵的左上角的位置
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // 通过左上角计算出右下角的位置
                int nx = i + c - 1;
                int ny = j + d - 1;
                if (nx > row || ny > col) {
                    continue;
                }
                // 计算出左上角为(i,j)，右下角为(nx,ny)的子矩阵和
                int sum = prefixSum[nx][ny] - prefixSum[i - 1][ny] - prefixSum[nx][j - 1] + prefixSum[i - 1][j - 1];
                // 元素和为0则为全0子矩阵（因为元素全部大于0）
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
