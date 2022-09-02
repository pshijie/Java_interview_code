package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/3 11:17
 * @File: BM65最长公共子序列Ⅱ.java
 * @Software: IntelliJ IDEA
 */
public class BM65最长公共子序列Ⅱ {
    public String LCS(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        // dp[i][j]表示从左到右，当处理到s1的第i个元素和s2的第j个元素时的公共子序列
        String[][] dp = new String[len1 + 1][len2 + 1];
        // base case：当i==0或j==0的情况，dp[i][j]为""，因为空字符串没有公共子序列
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = "";
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = "";
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 当前字符相等，则添加结果
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 如果只是求长度，则将s1.charAt(i - 1)删除即可
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    // 当前字符不相等，则还需要分两种情况，取长度较长的情况
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] :
                            dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2].equals("") ? "-1" : dp[len1][len2];
    }
}
