package 数字问题;

/**
 * @author psj
 * @date 2022/10/25 11:11
 * @File: 缺失的第一个正数.java
 * @Software: IntelliJ IDEA
 */
// Leetcode41
// https://leetcode.cn/problems/first-missing-positive/

public class 缺失的第一个正数 {
    // 置换
    // 如果数组中包含x∈[1,N]，那么恢复后数组的第x-1个元素为x
    // 在恢复后，数组应当有[1,2,...,N]的形式，但其中有若干个位置上的数是错误的，每一个错误的位置就代表了一个缺失的正数
    // 以[3, 4, -1, 1]为例，恢复后的数组应当为[1, -1, 3, 4]，可知道缺失的数为2
    // 恢复数组：
    //     对数组进行一次遍历，对于遍历到的数x=nums[i]，如果x∈[1,N]，就知道x应当出现在数组中的x-1的位置，因此交换nums[i]和nums[x−1]，这样x就出现在了正确的位置
    //     在完成交换后，新的nums[i]可能还在[1,N]的范围内，需要继续进行交换操作，直到x∈[1,N]
    //     上面的方法可能会陷入死循环。如果nums[i]恰好与nums[x−1]相等，会无限交换下去。此时nums[i]=x=nums[x−1]，说明x已经出现在了正确的位置。因此可以跳出循环，遍历下一个数。
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0
                    && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}