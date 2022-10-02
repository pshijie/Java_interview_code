package 前缀和;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/10/2 11:20
 * @File: 每个元音包含偶数次的最长子字符串.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1371
// https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/

public class 每个元音包含偶数次的最长子字符串 {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        // 比如遍历到第i个位置时uoiea出现次数的奇偶性为11001(0表示出现偶数次，1表示出现奇数次)
        // 因为五位二进制最大为32，所以申请一个32个int即可
        int[] pos = new int[32];  // pos[status]表示status状态第一次出现的下标
        Arrays.fill(pos, -1);
        int result = 0, status = 0;
        pos[0] = 0;  // *先把00000设置为0，这样后续不会更新(即00000第一次出现的位置就是没有字母的位置)
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 比如之前a出现了1次(原表示串为00101)，当前元素为a，则一共出现了2次，所以00101 ^ 1 = 00100
            if (c == 'a') {
                status ^= (1 << 0);
            } else if (c == 'e') {
                status ^= (1 << 1);
            } else if (c == 'i') {
                status ^= (1 << 2);
            } else if (c == 'o') {
                status ^= (1 << 3);
            } else if (c == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                result = Math.max(result, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return result;
    }
}
