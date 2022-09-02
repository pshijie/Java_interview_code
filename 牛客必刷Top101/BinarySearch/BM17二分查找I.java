package BinarySearch;

/**
 * @author psj
 * @date 2022/7/15 9:41
 * @File: BM17二分查找I.java
 * @Software: IntelliJ IDEA
 */
public class BM17二分查找I {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
