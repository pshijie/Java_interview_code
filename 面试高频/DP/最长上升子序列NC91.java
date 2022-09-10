package DP;

/**
 * @author psj
 * @date 2022/9/10 10:15
 * @File: 最长上升子序列NC91.java
 * @Software: IntelliJ IDEA
 */
public class 最长上升子序列NC91 {
    public int[] LIS(int[] arr) {
        int n = arr.length;
        // dp[i]表示以arr[i]结尾的最长上升子序列
        int[] dp = new int[n];
        // 单调递增数组
        int[] tail = new int[n];
        // 最长上升子序列长度
        int len = 0;

        for (int i = 0; i < n; i++) {
            // 当前arr[i]大于tail数组的末尾元素，则添加进来
            if (i == 0 || tail[len - 1] < arr[i]) {
                tail[len++] = arr[i];
                dp[i] = len;
            } else {
                // 找到tail数组中第一个大于等于arr[i]的元素位置
                int index = search(tail, len, arr[i]);
                // 更新index处的值，如果不更新后续比arr[index]大却比arr[i]小的值会获得和arr[i]一样的dp[i]
                tail[index] = arr[i];

                dp[i] = index + 1;
            }
        }
        int[] result = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                result[--len] = arr[i];
            }
        }
        return result;
    }

    // 找出tail数组中第一个大于等于k的位置
    int search(int[] nums, int len, int k) {
        int low = 0, high = len - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
