/**
 * @author psj
 * @date 2022/9/12 23:14
 * @File: 大小为K且平均值大于等于阈值的子数组数目.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1343
public class 大小为K且平均值大于等于阈值的子数组数目 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        // i表示窗口的右侧，j表示窗口的左侧，s为当前窗口的和
        for (int i = 0, j = 0, s = 0; i < arr.length; i++) {
            // 加上值就相当于i进行了右移
            s += arr[i];
            // 当窗口的大小大于k了
            // 需要先从s中删除arr[j]，再将j进行右移
            if (i - j >= k) {
                s -= arr[j];
                j++;
            }
            // 窗口的大小为k时判断是否满足条件
            if (i - j + 1 == k && s >= k * threshold) {
                result++;
            }
        }
        return result;
    }
}
