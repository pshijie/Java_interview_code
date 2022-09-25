package Array;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/9/25 9:34
 * @File: 缺失的第一个正整数NC30.java
 * @Software: IntelliJ IDEA
 */
public class 缺失的第一个正整数NC30 {
    public int minNumberDisappeared (int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], 1);
        }
        int res = 1;
        while (map.containsKey(res)){
            res++;
        }
        return res;
    }
}
