/**
 * @author psj
 * @date 2022/8/20 15:50
 * @File: longestPalindrome.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 5
// 给一个字符串s，找到s中最长的回文子串

public class longestPalindromeInterview {
    public String longestPalindrome(String s) {
        String result  = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = getSubStringPalindromLen(s, i, i);
            String s2 = getSubStringPalindromLen(s, i, i+1);
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }

    public String getSubStringPalindromLen(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                continue;
            }
            break;
        }
        return s.substring(left + 1, right);
    }
}
