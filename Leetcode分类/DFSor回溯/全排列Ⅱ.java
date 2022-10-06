package DFSor回溯;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 11:23
 * @File: 全排列Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 47
// https://leetcode.cn/problems/permutations-ii/

public class 全排列Ⅱ {
    // 和全排列的区别在于如果当前元素和上一个元素一样，并且上一个元素已经被撤销选择(即used[i-1]重新置为false)
    // 则不能选择当前元素继续遍历
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 需要排序，保证如果出现重复元素则一定是相邻的
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList<>(nums.length);
        dfs(nums, 0, path, used);
        return result;
    }

    private void dfs(int[] nums, int depth, ArrayList<Integer> path, boolean[] used) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 使用了used数组，所以i一直从0开始遍历即可
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // !used[i - 1]=true是因为nums[i - 1]在深度优先遍历的过程中刚被撤销选择
            // 所以不能使用和nums[i-1]相等的当前元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
