package DFSor回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 10:19
 * @File: 组合总和Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 40
// https://leetcode.cn/problems/combination-sum-ii/

public class 组合总和Ⅱ {
    // 和组合总和的区别在于遍历下一层的时候需要将索引值+1
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>(candidates.length);
        dfs(candidates, target, 0, path);
        return result;
    }

    private void dfs(int[] candidates, int residue, int begin, ArrayList<Integer> path) {
        if (residue == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 因为candidates从小到大排好序，如果residue减去当前数已经小于0了，后面减去一个更大的数肯定也小于0
            if (residue - candidates[i] < 0) {
                break;
            }
            // 如果当前元素和前一个元素一致，则不需要再往下遍历
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, residue - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}

