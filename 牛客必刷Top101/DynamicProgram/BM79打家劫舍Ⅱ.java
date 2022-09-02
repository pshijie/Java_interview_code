package DynamicProgram;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/8/10 10:48
 * @File: BM79打家劫舍Ⅱ.java
 * @Software: IntelliJ IDEA
 */
public class BM79打家劫舍Ⅱ {
    public int rob(int[] nums) {
        // dp[i]表示到第i+1家最多能偷到多少钱
        int[] dp = new int[nums.length + 1];
        // 选择偷第一家
        dp[1] = nums[0];
        // 则最后一家不能偷(i<nums.length,不是等于)
        for (int i = 2; i < nums.length; i++) {
            // 选择偷第i家，则只能从第i-2家过来(因为不能偷第i-1家)
            // 选择不偷第i家，则可以从第i-1家过来
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        // 最后一家不能偷
        int result = dp[nums.length - 1];
        Arrays.fill(dp, 0);
        // 选择不偷第一家
        dp[1] = 0;
        // 则可以偷最后一家(i<=nums.length)
        for (int i = 2; i <= nums.length; i++) {
            // 选择偷第i家，则只能从第i-2家过来(因为不能偷第i-1家)
            // 选择不偷第i家，则可以从第i-1家过来
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return Math.max(result, dp[nums.length]);
    }
}
