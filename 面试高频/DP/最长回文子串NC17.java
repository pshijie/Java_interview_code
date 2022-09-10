package DP;

/**
 * @author psj
 * @date 2022/9/10 9:06
 * @File: 最长回文子串NC17.java
 * @Software: IntelliJ IDEA
 */
public class 最长回文子串NC17 {
    public int getLongestPalindrome(String A) {
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            int r1 = getLongestPalindrome(A, i, i);
            int r2 = getLongestPalindrome(A, i, i + 1);
            int r = Math.max(r1, r2);
            result = Math.max(result, r);
        }
        return result;
    }

    private int getLongestPalindrome(String a, int left, int right) {
        while (left >= 0 && right < a.length()) {
            if (a.charAt(left) == a.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}
