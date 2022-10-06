package DFSor回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 11:04
 * @File: 全排列.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 46
// https://leetcode.cn/problems/permutations/

public class 全排列 {
    // 和组合总和不同在于不需要排序，排序的目的是为了剪枝
    // 并且使用used数组记录访问过的节点，在组合总和中如果元素不能重复直接遍历下一层的时候+1即可
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>(nums.length);
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used);
        return result;
    }

    private void dfs(int[] nums, int depth, List<Integer> path, boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 使用了used数组，所以i一直从0开始遍历即可
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, path, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
