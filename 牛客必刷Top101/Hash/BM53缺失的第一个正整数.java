package Hash;

/**
 * @author psj
 * @date 2022/7/26 11:48
 * @File: BM53缺失的第一个正整数.java
 * @Software: IntelliJ IDEA
 */
public class BM53缺失的第一个正整数 {
    public int minNumberDisappeared(int[] nums) {
        int n = nums.length;
        // 第一轮遍历:将nums中所有非正数忽略(即不参与后续的遍历)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }

        }
        // 第二轮遍历:做标记
        for (int i = 0; i < n; i++) {
            // 相当于把负数给剔除了
            // 之所以加上取绝对值是因为后续操作会把元素变为负数
            if (Math.abs(nums[i]) <= n) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        // 第三轮标记:下标没被标记的元素就是缺失的第一个正数
        // 因为遍历是从i=0开始,所以找到i就是第一个缺失的
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
