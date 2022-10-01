package 前缀和;


import java.util.HashMap;

/**
 * @author psj
 * @date 2022/10/1 10:48
 * @File: 统计优美子数组.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1248
// https://leetcode.cn/problems/count-number-of-nice-subarrays/

public class 统计优美子数组 {
    // 方法1:滑动窗口
    // 不断移动right扩大滑动窗口，使其包含k个奇数
    // 如果滑动窗口包含了k个奇数：
    //  1.统计第1个奇数左边的偶数个数count1,这count+1个偶数都可以作为优美子数组的起点
    //    所以起点选择为count1+1种(加1是因为可以一个偶数都不取)
    //  2.统计第k个奇数右边的偶数个数count2,这count+2个偶数都可以作为优美子数组的终点
    //    所以起点选择为count1+1种(加1是因为可以一个偶数都不取)
    //  3.所以优美子数组左右起点的选择组合数为(count1+1)*(count2+1)
    public int numberOfSubarrays_slideWindow(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, result = 0;
        while (right < nums.length) {
            // 右指针遇到一个奇数就修改oddCnt
            if ((nums[right] & 1) == 1) {
                oddCnt++;
            }
            right++;

            // 如果当前滑动窗口[left,right)中有k个奇数
            if (oddCnt == k) {
                // 将滑动窗口向右移动，直到遇到下一个奇数
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                // rightEvenCnt为第k个奇数右边的偶数个数
                int rightEvenCnt = right - tmp;
                // letfEvenCnt为当前区间第1个奇数左边的偶数个数
                int letfEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    letfEvenCnt++;
                    left++;
                }

                result += (letfEvenCnt + 1) * (rightEvenCnt + 1);
                // 此时left指向当前区间的第1个奇数，因为该区间已经统计完了，因此left右移一位，oddCnt--
                left++;
                oddCnt--;

            }
        }
        return result;
    }

    // 方法2:前缀和
    // 与Leetcode 560-和为K的子数组一样
    // 计算当前数组的前缀奇数和(统计遍历到当前元素时奇数的个数)后，查看有多少个前缀奇数和等于preSum-k
    // 因为满足preSum - (preSum - k) == k的区间个数是题目的解
    // 所以前缀奇数和为preSum - k的数量即为连续子数组和为k的数量
    public int numberOfSubarrays(int[] nums, int k) {
        // key：前缀数组奇数可能出现的值   value:出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int preSum = 0;  // 记录遍历到当前元素时，已有的奇数个数
        for (int num : nums) {
            // 当前元素为奇数
            if (num % 2 != 0) {
                preSum++;
            }

            // 前缀奇数和为preSum - k的数量即为连续子数组和为k的数量
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return count;
    }
}
