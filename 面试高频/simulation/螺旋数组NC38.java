package simulation;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/9/9 11:23
 * @File: 螺旋数组NC38.java
 * @Software: IntelliJ IDEA
 */
public class 螺旋数组NC38 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (top > bottom) {
                break;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return result;
    }
}
