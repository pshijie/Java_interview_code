package 数字问题;

import java.util.HashSet;

/**
 * @author psj
 * @date 2022/10/25 10:44
 * @File: 数组中重复的数字.java
 * @Software: IntelliJ IDEA
 */
// 剑指offer03
// https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

public class 数组中重复的数字 {
    // 方法1:set
    public int findRepeatNumber_set(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            // *如果添加了一个重复的元素就返回false
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // 方法2：原地
    // 遍历数组nums，设索引初始值为i = 0:
    //    若nums[i]=i：说明此数字已在对应索引位置，无需交换，跳过
    //    若nums[nums[i]]=nums[i]：代表索引nums[i]处和索引i处的元素值都为nums[i]，即找到一组重复值，返回此值nums[i]
    //    否则交换索引为i和nums[i]的元素值，将此数字交换至对应索引位置
    // 若遍历完毕尚未返回，则返回-1
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
