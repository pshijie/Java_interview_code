/**
 * @author psj
 * @date 2022/9/21 23:03
 * @File: 每个元音包含偶数次的最长子字符串.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1371
public class 每个元音包含偶数次的最长子字符串 {
    // 假设字符串前j个字符中aeiou每个字符出现次数的奇偶性为奇奇偶偶奇
    // 如果子字符串[i+1...j]是符合要求的子字符串，则[0...i]中aeiou每个字符出现次数的奇偶性也为奇奇偶偶奇
    // 因为在[i+1...j]中这五个字符出现次数为偶数，奇奇偶偶奇-偶=奇奇偶偶奇
    public int findTheLongestSubstring(String s) {
        // 0代表出现次数为偶数，1表示出现次数为奇数
        // 则aeiou五个字母可能是00000，00001...11111共32个状态
        int[] cnt = new int[32];
        for (int i = 0; i < 32; i++) {
            cnt[i] = -2;
        }

        String cs = "aeiou";
        cnt[0] = -1;  // 表示00000，五个字符出现次数都是偶数
        int result = 0, state = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = cs.indexOf(s.charAt(i));
            if (k != -1) {
                state ^= 1 << k;
            }
            if (cnt[state] != -2) {
                // 每个状态后续再次出现，就记录下与首次出现的位置中间的距离
                result = Math.max(result, i - cnt[state]);
            } else {
                // 记录每个状态(即00000...)首次出现的位置
                cnt[state] = i;
            }
        }
        return result;
    }
}
