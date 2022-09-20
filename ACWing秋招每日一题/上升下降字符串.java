/**
 * @author psj
 * @date 2022/9/20 23:24
 * @File: 上升下降字符串.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1370
public class 上升下降字符串 {
    public String sortString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        while (result.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    result.append((char) (i + 'a'));
                    cnt[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    result.append((char) (i + 'a'));
                    cnt[i]--;
                }
            }
        }

        return result.toString();
    }
}
