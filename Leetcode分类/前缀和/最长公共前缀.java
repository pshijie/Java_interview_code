package 前缀和;

/**
 * @author psj
 * @date 2022/10/2 11:48
 * @File: 最长公共前缀.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 14
// https://leetcode.cn/problems/longest-common-prefix/
// 未使用前缀和的思想
public class 最长公共前缀 {
    // 纵向扫描
    // 字符串1:k e a l  ↓
    // 字符串2:k e y l  ↓
    // 字符串3:k e a o  ↓
    // 1.以第一个字符串为基准开始遍历每个字符
    // 2.遍历每个字符时看其他字符串在当前位置是否和当前遍历的字符一致
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // 1.如果当前遍历的字符的位置已经大于后续的字符串长度
                // 2.如果当前遍历的字符的当前元素和基准字符串当前位置的元素不一致
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
