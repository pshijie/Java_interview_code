package DP;

/**
 * @author psj
 * @date 2022/9/9 10:32
 * @File: 最长公共子串NC127.java
 * @Software: IntelliJ IDEA
 */
public class 最长公共子串NC127 {
    public String LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        // dp[i][j]表示str1[0...i]和strs[0...j]的最长公共子串长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        int index = 0;
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        index = i;
                    }
                } else {
                    dp[i][j] = 0;
                }

            }
        }

        return str1.substring(index - maxLen, index);
    }
}
