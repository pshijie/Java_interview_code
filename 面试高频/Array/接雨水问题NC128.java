package Array;

/**
 * @author psj
 * @date 2022/9/12 10:06
 * @File: 接雨水问题NC128.java
 * @Software: IntelliJ IDEA
 */
public class 接雨水问题NC128 {
    public long maxWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long result = 0;
        int size = arr.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = arr[0];  // 第一个柱子左侧最高高度为第一个柱子的高度
        right_max[size - 1] = arr[size - 1];  // 最后一个柱子右侧最高高度为最后一个柱子的高度

        int minLeft = left_max[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(left_max[i - 1], arr[i]);
        }
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], arr[i]);
        }
        for (int i = 1; i < size - 1; i++) {
            result += Math.min(right_max[i], left_max[i]) - arr[i];
        }
        return result;
    }
}
