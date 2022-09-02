package simulation;

/**
 * @author psj
 * @date 2022/8/15 11:42
 * @File: BM97旋转数组.java
 * @Software: IntelliJ IDEA
 */
public class BM97旋转数组 {
    // 方法1:常规方法
//     public int[] solve (int n, int m, int[] a) {
//         // 将后m位不断移动到前m位(即每次取一位不断从末尾和前一位进行交换)
//         for(m = m % n; m > 0; m--){
//             // 每位交换的次数都是n-1
//             for(int i = n-1;i>0;i--){
//                 swap(a, i, i-1);
//             }
//         }
//         return a;
//     }
//     public void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }

    // 方法2:旋转三次
    public int[] solve(int n, int m, int[] a) {
        m = m % n;  // 防止m过大
        // 1.旋转全部数组
        reverse(a, 0, n - 1);
        // 2.旋转前m个子数组
        reverse(a, 0, m - 1);
        // 3.旋转剩余子数组
        reverse(a, m, n - 1);
        return a;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
