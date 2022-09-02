/**
 * @author psj
 * @date 2022/9/2 16:33
 * @File: 计数排序.java
 * @Software: IntelliJ IDEA
 */
public class 计数排序 {
    public static void bucketSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        // 找出数组中的最大值，用于决定桶的个数
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        int[] bucket = new int[max + 1];
        // 比如第一个数为1，则将桶1的计数+1(桶1代表该桶中都是1，所以不需要存储桶中数字，只需要出现次数)
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
        int k = 0;  // 重排数组的下标
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                a[k] = i;
                bucket[i]--;
                k++;
            }
        }
    }
}
