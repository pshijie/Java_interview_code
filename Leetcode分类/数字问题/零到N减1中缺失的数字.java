package 数字问题;

/**
 * @author psj
 * @date 2022/10/27 9:41
 * @File: 零到N减1中缺失的数字.java
 * @Software: IntelliJ IDEA
 */
// 剑指Offer53-II
// https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/

public class 零到N减1中缺失的数字 {
    // 方法1：遍历数组，找到第一个不满足nums[i] = i的数字
//    public int missingNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i) {
//                return i;
//            }
//        }
//        return nums.length;
//    }

    // 方法2：二分查找
    // 缺失的数字等于"右子数组的首位元素"对应的索引
    //     左子数组：nums[i] = i
    //     右子数组：nums[i] != i
    // 索引：0 1 2 3 4 5 6 7 8
    //   值：0 1 2 3 4 5 6 7|9
    // 其中，值7为左子数组最后一个元素，值9为右子数组首尾元素
//    public int missingNumber(int[] nums) {
//        int i = 0, j = nums.length - 1;
//        while (i <= j) {
//            int mid = (i + j) / 2;
//            if (nums[mid] == mid) {
//                i = mid + 1;
//            } else {
//                j = mid - 1;
//            }
//        }
//        return i;
//    }

    // 方法3：求和
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return actualSum - expectSum;
    }
}
