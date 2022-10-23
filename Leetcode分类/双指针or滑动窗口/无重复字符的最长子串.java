package 双指针or滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/10/23 11:42
 * @File: 无重复字符的最长子串.java
 * @Software: IntelliJ IDEA
 */
// Leetcode3
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

public class 无重复字符的最长子串 {
    // 重点在于使用map将每个字符最新的位置进行保存，等下次发现相同字符是左指针就可以直接移动到最近位置
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0, right = 0;
        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                // 不能直接赋值为map.get(s.charAt(right)) + 1,还需要进行比较
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
