import java.util.Map;

/**
 * @author psj
 * @date 2022/8/22 21:35
 * @File: trapInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 42
public class trapInterview {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int result = 0;

        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];

        left_max[0] = height[0];
        right_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            result += Math.min(right_max[i], left_max[i]) - height[i];
        }
        return result;
    }
}
