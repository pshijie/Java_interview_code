package DFSor回溯;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 10:03
 * @File: 组合总和.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 39
// https://leetcode.cn/problems/combination-sum/

public class 组合总和 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    // residue：剩余数值  begin：本轮搜索起始下标  path:从根节点到任意节点路径
    private void dfs(int[] candidates, int residue, int begin, List<Integer> path) {
        if (residue == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 因为candidates从小到大排好序，如果residue减去当前数已经小于0了，后面减去一个更大的数肯定也小于0
            if (residue - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            // 因为当前元素可重复使用，所以可以将i直接传递给下一层
            dfs(candidates, residue - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
