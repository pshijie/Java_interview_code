package DFSor回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/9 10:40
 * @File: 子集Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode90
// https://leetcode.cn/problems/subsets-ii/

public class 子集Ⅱ {
    // 与子集不同的地方是nums中存在重复的元素，所以需要先进行排序，
    // 并且在遍历的时候要判断当前元素和上一个元素是否相等
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> temp) {
        // 直接添加，不需要判断temp的长度，因为结果需要所有子集
        result.add(new ArrayList<>(temp));

        // 因为不能出现重复的元素，需要进行当前元素和上一个元素值的判断
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, i + 1, temp);    // 这里不是index+1,而是i+1
            temp.remove(temp.size() - 1);
        }
    }
}
