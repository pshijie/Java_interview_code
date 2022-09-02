package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/5 11:40
 * @File: BM73最长回文子串.java
 * @Software: IntelliJ IDEA
 */
public class BM73最长回文子串 {
    public int getLongestPalindrome(String A) {
        int n = A.length();
        if (n < 2) {
            return n;
        }
        int result = 0;
        // 尝试每个字符都作为中心点
        for (int i = 0; i < n; i++) {
            // 分别计算以一个字符(A的长度为奇数)为中心点和两个字符(A的长度为奇数)作为中心点
            // 哪个大就取哪个
            int curMax = helper(A, i, i) > helper(A, i, i + 1) ? helper(A, i, i) : helper(A,
                    i, i + 1);
            result = Math.max(result, curMax);
        }
        return result;
    }

    public int helper(String A, int left, int right) {
        // 向两边扩散
        while (left >= 0 && right < A.length()) {
            if (A.charAt(left) == A.charAt(right)) {
                left--;
                right++;
                continue;
            }
            // 不相等就不需要要在扩散
            break;
        }
        // -2是因为此时的right和left不符合条件，但是在上一轮两个指针都进行了移动
        // +1是因为下标计算长度多减了1
        return right - left + 1 - 2;
    }
}
