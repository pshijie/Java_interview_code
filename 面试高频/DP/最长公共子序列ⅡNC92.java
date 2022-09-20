package DP;

import java.util.Map;

/**
 * @author psj
 * @date 2022/9/20 9:36
 * @File: 最长公共子序列ⅡNC92.java
 * @Software: IntelliJ IDEA
 */
public class 最长公共子序列ⅡNC92 {
    public String LCS(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return "-1";
        }
        if (s2 == null || s2.length() == 0) {
            return "-1";
        }

        int m = s1.length();
        int n = s2.length();
        // dp[i][j]表示s1[0...i-1]和s2[0...j-1]之间最长公共子序列
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = "";
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = "";
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[m][n] == "" ? "-1" : dp[m][n];
    }
}
