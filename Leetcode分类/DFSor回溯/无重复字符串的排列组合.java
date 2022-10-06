package DFSor回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 11:16
 * @File: 无重复字符串的排列组合.java
 * @Software: IntelliJ IDEA
 */
// 面试题08.07
// https://leetcode.cn/problems/permutation-i-lcci/

public class 无重复字符串的排列组合 {
    // 解法和全排列一致，主要区别在于最后将List集合转换为String数组
    List<String> result = new ArrayList<>();

    public String[] permutation(String S) {
        if (S == null || S.length() == 0) {
            return new String[0];
        }
        boolean[] used = new boolean[S.length()];
        StringBuilder sb = new StringBuilder();
        dfs(S, used, sb);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(String s, boolean[] used, StringBuilder sb) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        // 使用了used数组，所以i一直从0开始遍历即可
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                sb.append(s.charAt(i));
                used[i] = true;
                dfs(s, used, sb);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
