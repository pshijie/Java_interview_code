package DynamicProgram;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/8/4 12:30
 * @File: BM70兑换零钱Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM70兑换零钱Ⅰ {
    public int minMoney(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (aim == 0) {
            return 0;
        }
        // dp[i]表示组成i需要的最少货币数
        int[] dp = new int[aim + 1];
        // 不能赋值为Integer.MAX_VALUE，因为后续的加1操作可能会导致溢出
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 当前货币面值需要小于等于目标金额才能使用
                if (arr[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }

            }

        }
        return dp[aim] == aim + 1 ? -1 : dp[aim];
    }


}
