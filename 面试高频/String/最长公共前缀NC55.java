package String;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/9/30 9:26
 * @File: 最长公共前缀NC55.java
 * @Software: IntelliJ IDEA
 */
public class 最长公共前缀NC55 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String prefix = strs[0];
        // 以此得到两个字符串的最长前缀，再和第三个字符串比较前缀
        for (int i = 1; i < strs.length; i++) {
            prefix = GetCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    // 返回两子串公共前缀函数
    public String GetCommonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int flag = 0;
        while (flag < len && s1.charAt(flag) == s2.charAt(flag)) {
            flag++;
        }
        return s1.substring(0, flag);
    }
}
