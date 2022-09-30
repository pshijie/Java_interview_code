package Array;

/**
 * @author psj
 * @date 2022/9/30 9:47
 * @File: 二分查找ⅡNC105.java
 * @Software: IntelliJ IDEA
 */
public class 二分查找ⅡNC105 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 找到目标位置后继续向左找（因为是找元素第一个出现的位置）
                while (mid != 0 && nums[mid] == nums[mid - 1]) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }
}
