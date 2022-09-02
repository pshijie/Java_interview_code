package DynamicProgram;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/8/5 11:16
 * @File: BM71最长上升子序列Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM71最长上升子序列Ⅰ {
    public int LIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        // dp[i]表示以arr[i]结尾的最长递增子序列长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果当前结尾数arr[i]大于arr[j]，则在dp[j]的基础上加1即可得到当前的dp[i]
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
