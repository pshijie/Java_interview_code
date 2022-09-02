package Greedy;

/**
 * @author psj
 * @date 2022/8/14 11:25
 * @File: BM95分糖果问题.java
 * @Software: IntelliJ IDEA
 */
public class BM95分糖果问题 {
    public int candy(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        int[] nums = new int[n];
        // 初始化:每个位置至少分到一个糖果
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }
        // 1.从左向右遍历，如果i比前一位i-1大，则i分得的糖果数加1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        int result = nums[n - 1];
        // 从右向左遍历，如果i比i+1大但是分得糖果数少，则i分得糖果数加1
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && nums[i] <= nums[i + 1]) {
                nums[i] = nums[i + 1] + 1;
            }
            result += nums[i];
        }
        return result;
    }
}
