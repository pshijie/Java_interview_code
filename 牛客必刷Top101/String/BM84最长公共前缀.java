package String;

/**
 * @author psj
 * @date 2022/8/12 10:58
 * @File: BM84最长公共前缀.java
 * @Software: IntelliJ IDEA
 */
public class BM84最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = getPrefix(result, strs[i]);
        }
        return result;
    }

    public String getPrefix(String s1, String s2) {
        int i = 0, j = 0;
        for (; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                continue;
            } else {
                break;
            }
        }
        return s1.substring(0, i);
    }
}
