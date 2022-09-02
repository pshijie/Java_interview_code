package DoublePointer;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/8/13 10:51
 * @File: BM90最小覆盖子串.java
 * @Software: IntelliJ IDEA
 */
public class BM90最小覆盖子串 {
    public String minWindow(String S, String T) {
        // 用于记录字符串t中每个字符和出现次数的映射
        HashMap<Character, Integer> need = new HashMap<>();
        // 用于记录当前窗口每个字符和出现次数的映射
        HashMap<Character, Integer> window = new HashMap<>();

        // 统计t中字符出现的次数
        for (char c : T.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;  // 记录左窗口和右窗口的位置
        int vaild = 0;  // 存储当前窗口达到字符要求的字符数目
        int start = 0, len = Integer.MAX_VALUE;  // 记录最小覆盖子串的起始位置和其长度
        while (right < S.length()) {
            char c = S.charAt(right);  // 移入窗口的字符
            right++;
            // 进行数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 不要用==，因为此时比较的是Integer对象
                if (window.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            // 判断左窗口是否要收缩(当前窗口每个字符数目达到要求数目开始收缩，当其中某个字符的数目由于减少没达到要求数则停止收缩)
            while (vaild == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = S.charAt(left);  // 移除窗口的字符
                left++;  // 移动左窗口
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        vaild--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }
}
