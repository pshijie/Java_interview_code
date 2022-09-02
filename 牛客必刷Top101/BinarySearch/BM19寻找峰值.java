package BinarySearch;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/7/15 9:58
 * @File: BM19寻找峰值.java
 * @Software: IntelliJ IDEA
 */
public class BM19寻找峰值 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 右侧开始往下，则可能mid本身就是波峰
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {  // 右侧开始向上，说明往右边移动肯定可以找到波峰(也可能是mid+1)
                left = mid + 1;
            }
        }
        // 这里是返回任意一个
        return right;
    }
}
