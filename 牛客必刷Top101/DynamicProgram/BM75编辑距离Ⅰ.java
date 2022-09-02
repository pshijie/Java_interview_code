package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/6 11:28
 * @File: BM75编辑距离Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM75编辑距离Ⅰ {
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        // dp[i][j]表示将str1[0...i]转换为str2[0...j]的最少操作数
        int[][] dp = new int[m + 1][n + 1];
        // 假设str1的长度为5，则dp[5][0]表示整个字符串转为空串的最小编辑距离为5
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 两个字符相等则无需进行操作
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 两个字符不相等则需要进行3个操作(分别对应str1的删除、修改和插入)
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
