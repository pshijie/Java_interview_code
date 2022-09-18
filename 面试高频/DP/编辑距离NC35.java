package DP;

/**
 * @author psj
 * @date 2022/9/17 9:40
 * @File: 编辑距离NC35.java
 * @Software: IntelliJ IDEA
 */
public class 编辑距离NC35 {
    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str1.length() == 0) {
            if (str2 == null) {
                return 0;
            }
            return str2.length() * ic;
        }
        if (str2 == null || str2.length() == 0) {
            if (str1 == null) {
                return 0;
            }
            return str1.length() * ic;
        }

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = ic * i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + dc, Math.min(dp[i][j - 1] + ic, dp[i - 1][j - 1] + rc));
                }
            }
        }
        return dp[len1][len2];
    }
}

