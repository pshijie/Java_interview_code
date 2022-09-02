package DoublePointer;

/**
 * @author psj
 * @date 2022/8/14 11:03
 * @File: BM94接雨水问题.java
 * @Software: IntelliJ IDEA
 */
public class BM94接雨水问题 {
// 方法1和方法2的核心思想:将每个柱子单独看待
    // 方法1:暴力(超时)
//     public long maxWater (int[] arr) {
//         int n = arr.length;
//         int result = 0;
//         // 以除了两侧外的其他柱作为中心
//         for(int i = 1; i < n - 1; i++){
//             int left_max = 0;  // 记录左边最高柱的值
//             int right_max = 0;  // 记录右边最高柱的值
//             for(int j = i; j < n; j++){
//                 right_max = Math.max(right_max, arr[j]);
//             }
//             for(int j = i; j >= 0; j--){
//                 left_max = Math.max(left_max, arr[j]);
//             }
//             result += Math.min(left_max, right_max) - arr[i];
//         }
//         return result;
//     }


    // 方法2:提前保存每个柱子左右侧最高柱子高度(包括自己)
    public long maxWater(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int n = arr.length;
        // 保存每个柱子(包括左右端的柱子)
        int[] left_max = new int[n];
        left_max[0] = arr[0];  // 第一个柱子左侧最高高度为第一个柱子的高度
        int[] right_max = new int[n];  // 最后一个柱子右侧最高高度为最后一个柱子的高度
        right_max[n - 1] = arr[n - 1];
        // 都是和当前柱子的高度进行比较
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], arr[i]);
        }
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            result += Math.min(right_max[i], left_max[i]) - arr[i];
        }
        return result;
    }
}
