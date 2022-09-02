import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/8/20 16:59
 * @File: spiralOrder.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 54
public class spiralOrderInterview {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

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
            bottom--;
            if (top > bottom) {
                break;
            }

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
