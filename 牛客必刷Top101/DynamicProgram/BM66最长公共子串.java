package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/3 12:14
 * @File: BM66最长公共子串.java
 * @Software: IntelliJ IDEA
 */
public class BM66最长公共子串 {
    public String LCS(String str1, String str2) {
        int maxLen = 0;  // 记录当前最长公共子串的长度
        int maxLastIndex = 0;  // 记录当前最大长度对应的str1的下标
        // dp[i][j]表示字符串str1中第i个字符和str2种第j个字符为最后一个元素所构成的最长公共子串长度
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j + 1];
                        maxLastIndex = i;
                    }
                } else {
                    // 最后一个字符不相等则无法成为一个子串(子串要求连续)
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str1.substring(maxLastIndex - maxLen + 1, maxLastIndex + 1);
    }
}
