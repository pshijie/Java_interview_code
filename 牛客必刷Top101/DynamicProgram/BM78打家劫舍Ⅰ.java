package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/9 11:51
 * @File: BM78打家劫舍Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM78打家劫舍Ⅰ {
    public int rob(int[] nums) {
        int n = nums.length;
        // n表示到第n-1家时最大金额
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            // 到第i家有两种情况：不抢第i-1家和抢第i-2家
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
