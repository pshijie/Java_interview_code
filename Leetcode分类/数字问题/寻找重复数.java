package 数字问题;

/**
 * @author psj
 * @date 2022/10/25 10:16
 * @File: 寻找重复数.java
 * @Software: IntelliJ IDEA
 */
// Leetcode287
// https://leetcode.cn/problems/find-the-duplicate-number/

public class 寻找重复数 {
    // 二分法：
    // 比如[1,7]的中位数是4，遍历整个数组，统计出小于等于4的个数
    // 如果不存在重复元素，则统计的个数最多为4；如果统计的个数大于4时，说明存在重复的数在区间[1,4]中
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            // 小于等于4的个数如果大于4个,重复元素一定在[1,4]区间里
            if (cnt > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
