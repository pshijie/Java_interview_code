/**
 * @author psj
 * @date 2022/8/24 23:11
 * @File: findKthLargestInterview.java
 * @Software: IntelliJ IDEA
 */
public class findKthLargestInterview {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p < k-1) {
                low = p + 1;
            } else if (p > k-1) {
                high = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    // 降序
    public int partition(int[] nums, int low, int high) {
        int dummy = nums[low];
        int begin = low;
        while (low < high) {
            while (low < high && nums[high] <= dummy) {
                high--;
            }
            while (low < high && nums[low] >= dummy) {
                low++;
            }
            if (low < high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }

        int temp = nums[begin];
        nums[begin] = nums[low];
        nums[low] = temp;

        return low;
    }
}
