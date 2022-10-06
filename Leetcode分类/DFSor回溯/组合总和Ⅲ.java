package DFSor回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 10:39
 * @File: 组合总和Ⅲ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 216
// https://leetcode.cn/problems/combination-sum-iii/

public class 组合总和Ⅲ {
    // 在组合总和Ⅱ的基础上对k进行判断即可
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0 || k > n) {
            return result;
        }
        // 因为数只为1-9,所以k个数的最大和为9+8+...(9-k-1) = (19-k)*k/2
        if (n > (19 - k) * k / 2) {
            return result;
        }
        // 不需要排序是因为默认使用的数组就是1,2,3...
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k, n, 1, path);
        return result;
    }

    private void dfs(int k, int residue, int begin, Deque<Integer> path) {
        // 如果[begin,9]的个数不足k个
        if (10 - begin < k) {
            return;
        }
        if (k == 0) {
            if (residue == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
        }

        // 假设找3个数，起点最多到7(所以起点上界=10-k)
        for (int i = begin; i <= 10 - k; i++) {
            if (residue - i < 0) {
                break;
            }
            path.addLast(i);
            // 因为最多使用1次，所以不能重复使用
            dfs(k - 1, residue - i, i + 1, path);
            path.removeLast();
        }
    }
}
