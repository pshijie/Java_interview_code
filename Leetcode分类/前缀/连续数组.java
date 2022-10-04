package 前缀;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/10/2 10:57
 * @File: 前缀和.连续数组.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 525
// https://leetcode.cn/problems/contiguous-array/

public class 连续数组 {
    // 1.*将0视为-1，则区间的和为0说明该区间的1和0的数量一样(问题转换为最长的连续子数组，其元素和为0)
    //   要使得区间[i,j]和为0,则preSum[j] = preSum[i]
    // 2.map的key为前缀和，value为该和第一次出现的索引位置
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max = 0, preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            // 把0视为-1，1还是1
            if (nums[i] == 1) {
                preSum += 1;
            } else {
                preSum += -1;
            }
            // 如果出现了相同的前缀和，说明区间和为0
            if (map.containsKey(preSum)) {
                max = Math.max(max, i - map.get(preSum));
            } else {
                map.put(preSum, i);  // 只记录该值第一次出现的位置
            }
        }
        return max;
    }
}
