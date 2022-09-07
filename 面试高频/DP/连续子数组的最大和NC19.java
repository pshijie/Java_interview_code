package DP;


/**
 * @author psj
 * @date 2022/9/7 10:42
 * @File: 连续子数组的最大和NC19.java
 * @Software: IntelliJ IDEA
 */
public class 连续子数组的最大和NC19 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + array[i - 1];
            } else {
                dp[i] = array[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
