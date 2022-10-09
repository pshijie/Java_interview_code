package DFSor回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/9 10:33
 * @File: 子集.java
 * @Software: IntelliJ IDEA
 */
// Leetcode78
// https://leetcode.cn/problems/subsets/

public class 子集 {
    // nums中没有重复元素，所以不需要先进行排序
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
//        // 为什么子集Ⅱ不需要判断长度？
//        // 因为下面解法中选择和不选择都会将index+1
//        // 即使index==nums.length也不代表path的长度是nums.length
        if (index == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        // 不选择当前元素
        dfs(nums, index + 1, path);

        // 选择当前元素(需要回溯，因为需要在path中添加不同的下一层元素)
        path.add(nums[index]);
        dfs(nums, index + 1, path);
        path.remove(path.size() - 1);

        // 使用和子集Ⅱ一样的解法
//        result.add(new ArrayList<>(path));
//        for (int i = index; i < nums.length; i++) {
//            path.add(nums[i]);
//            dfs(nums, i + 1, path);  // 这里不是index+1,而是i+1
//            path.remove(path.size() - 1);
//
//        }
    }
}
