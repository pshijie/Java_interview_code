package DoublePointer;

/**
 * @author psj
 * @date 2022/8/13 12:31
 * @File: BM93盛水最多的容器.java
 * @Software: IntelliJ IDEA
 */
public class BM93盛水最多的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int cap = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, cap);
            // 移动高度低的一边(储水始终以短的一边为基准)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
