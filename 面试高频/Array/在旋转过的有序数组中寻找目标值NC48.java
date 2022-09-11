package Array;

/**
 * @author psj
 * @date 2022/9/11 11:02
 * @File: 在旋转过的有序数组中寻找目标值NC48.java
 * @Software: IntelliJ IDEA
 */
public class 在旋转过的有序数组中寻找目标值NC48 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
                // [left...mid]为有序区间
            } else if (nums[left] < nums[mid]) {
                // target不在该有序区间内
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                // [mid...right]为有序区间
            } else {
                // target不在这个有序区间
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
