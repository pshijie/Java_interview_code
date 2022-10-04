package 前缀;

import java.util.TreeMap;

/**
 * @author psj
 * @date 2022/10/1 11:25
 * @File: 区间和的个数.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 327
// https://leetcode.cn/problems/count-of-range-sum/

public class 区间和的个数 {
    // 方法1：前缀和+TreeMap(超时)
    // 计算当前数组的前缀和后，查看有多少个前缀和等于preSum-x
    // 因为满足preSum - (preSum - lower) == lower和preSum - (preSum - upper) == upper的区间个数是题目的解
    // 所以前缀和为preSum - x(x在[lower,upper]之间)的数量和即为连续子数组和为在区间[lower,upper]的数量
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // key:区间和  value:该区间和出现的次数
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        treeMap.put(0L, 1);
        int count = 0;
        long sum = 0L;

        for (int num : nums) {
            sum += num;
            // subMap()返回一个值在sum-upper和sum-lower之间的子集合
            // values()方法获得这个映射值的视图
            for (int cnt : treeMap.subMap(sum - upper, true, sum - lower, true).values()) {
                count += cnt;
            }

            treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 方法2:归并
    public int countRangeSum_merge(int[] nums, int lower, int upper) {
        int count = 0;
        long[] preSum = new long[nums.length];
        long sum = 0;
        // preSum[i]表示nums[0...i]的和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }

        count = mergeSort(preSum, 0, nums.length - 1, lower, upper);
        return count;
    }

    private int mergeSort(long[] preSum, int left, int right, int lower, int upper) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            if (preSum[left] >= lower && preSum[right] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int count;
        int mid = left + (right - left) / 2;
        count = mergeSort(preSum, left, mid, lower, upper) +
                mergeSort(preSum, mid + 1, right, lower, upper);
        int low_bound = mid + 1;
        int up_bound = mid + 1;
        for (int i = left; i <= mid; i++) { // 计数
            // 退出while后low_bound是在右边数组中第一个使得preSum[low_bound]-preSum[i] >= lower的位置
            while (low_bound <= right && preSum[low_bound] - preSum[i] < lower) {
                low_bound++;
            }
            // up_bound是在右边数组中第一个使得preSum[up_bound] - preSum[i] > upper的位置
            while (up_bound <= right && preSum[up_bound] - preSum[i] <= upper) {
                count += (up_bound - low_bound);
            }
        }
        long[] merged = new long[right - left + 1];
        int l = left, r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (preSum[l] <= preSum[r]) {
                merged[index++] = preSum[l++];
            } else {
                merged[index++] = preSum[r++];
            }
        }
        while (l <= mid) merged[index++] = preSum[l++];
        while (r <= right) merged[index++] = preSum[r++];
        System.arraycopy(merged, 0, preSum, left, merged.length);
        return count;
    }
}
