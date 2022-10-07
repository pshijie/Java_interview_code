package DFSor回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/7 10:28
 * @File: 排列序列.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 60
// https://leetcode.cn/problems/permutation-sequence/

public class 排列序列 {
    //                       1234
    //          1/            2|          3\             4\
    //         234            134          124            123
    //     2/  3|  4\         .....
    //    ...
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        boolean[] used = new boolean[n];
        // 每个String只存储一个字符
        List<String> levelList = new ArrayList<>();
        return dfs(nums, levelList, used, 0, n, k);
    }

    private String dfs(int[] nums, List<String> levelList, boolean[] used, int depth, int n, int k) {
        if (depth == n) {
            StringBuilder result = new StringBuilder();
            for (String s : levelList) {
                result.append(s);
            }
            return result.toString();
        }
        // 查看剩余的字符还剩下多少排列组合数
        // 比如选了1后，234还剩下3！=6种排列组合
        int cur = factorial(n - depth - 1);

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            // 如果当前的排列组合数小于k，说明就算这棵子树排完了也到不了第k个，需要剪枝
            if (cur < k) {
                k -= cur;
                continue;
            }

            levelList.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, levelList, used, depth + 1, n, k);
        }
        return null;
    }

    //返回n的阶乘
    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }
}
