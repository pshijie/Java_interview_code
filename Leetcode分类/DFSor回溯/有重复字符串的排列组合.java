package DFSor回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/7 10:15
 * @File: 有重复字符串的排列组合.java
 * @Software: IntelliJ IDEA
 */
// 面试题08.08
// https://leetcode.cn/problems/permutation-ii-lcci/

public class 有重复字符串的排列组合 {
    // 和全排列Ⅱ方法一致
    List<String> result = new ArrayList<>();

    public String[] permutation(String S) {
        if (S == null || S.length() == 0) {
            return new String[0];
        }
        int n = S.length();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[n];
        StringBuilder sb = new StringBuilder(n);
        dfs(chars, 0, used, sb);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(char[] s, int begin, boolean[] used, StringBuilder path) {
        if (begin == s.length) {
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (used[i]) {
                continue;
            }
            // !used[i - 1]=true是因为s[i - 1]在深度优先遍历的过程中刚被撤销选择
            // 所以不能使用和s[i-1]相等的当前元素
            if (i > 0 && s[i] == s[i - 1] && !used[i - 1]) {
                continue;
            }

            path.append(s[i]);
            used[i] = true;
            dfs(s, begin + 1, used, path);
            used[i] = false;
            path.deleteCharAt(begin);
        }
    }
}
