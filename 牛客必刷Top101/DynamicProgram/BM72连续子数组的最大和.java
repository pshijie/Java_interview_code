package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/5 11:38
 * @File: BM72连续子数组的最大和.java
 * @Software: IntelliJ IDEA
 */
public class BM72连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        // dp[i]表示以array[i]结尾的子数组的最大和
        int[] dp = new int[n];
        int result = array[0];
        dp[0] = array[0];

        for (int i = 1; i < n; i++) {
            // 选择直接以array[i]作为子数组还是将array[i]拼接到原子数组后
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            result = Math.max(result, dp[i]);  // 结果不一定是以array[n-1]结尾的子数组
        }
        return result;
    }
}
