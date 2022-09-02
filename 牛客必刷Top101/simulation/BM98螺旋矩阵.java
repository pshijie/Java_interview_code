package simulation;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/8/15 12:29
 * @File: BM98螺旋矩阵.java
 * @Software: IntelliJ IDEA
 */
public class BM98螺旋矩阵 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0;  // 左边界
        int right = matrix[0].length - 1;
        int up = 0;  // 上边界
        int down = matrix.length - 1;  // 下边界
        while (left <= right && up <= down) {
            // 上边界的从左到右
            for (int i = left; i <= right; i++)
                result.add(matrix[up][i]);
            // 上边界向下
            up++;
            if (up > down)
                break;
            // 右边界的从上到下
            for (int i = up; i <= down; i++)
                result.add(matrix[i][right]);
            // 右边界向左
            right--;
            if (left > right)
                break;
            // 下边界的从右到左
            for (int i = right; i >= left; i--)
                result.add(matrix[down][i]);
            // 下边界向上
            down--;
            if (up > down)
                break;
            // 左边界的从下到上
            for (int i = down; i >= up; i--)
                result.add(matrix[i][left]);
            // 左边界向右
            left++;
            if (left > right)
                break;
        }
        return result;
    }
}
