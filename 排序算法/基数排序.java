/**
 * @author psj
 * @date 2022/9/2 16:32
 * @File: 基数排序.java
 * @Software: IntelliJ IDEA
 */
public class 基数排序 {
    // 获取数组中的最大值
    public static int getMax(int[] a) {
        int max;
        max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    // 对数组按照"某个位数"进行排序(桶排序)
    // exp表示当前对个位(exp=1)、十位(exp=10)...进行排序
    public static void countSort(int[] a, int exp) {
        int[] output = new int[a.length];  // 存储被排序数据的临时数组
        int[] buckets = new int[10];

        // 将数组中每个元素在exp位出现数字出现的次数进行统计
        for (int i = 0; i < a.length; i++) {
            buckets[(a[i] / exp) % 10]++;
        }

        // 将buckets存储原buckets的前缀和
        // 比如buckets[2]=buckets[1] + buckets[2]=num,
        // 表示整个数组在exp位置排序后一共有num个数字在exp位小于等于2
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            // 减1是因为output数组从0开始
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }

        // 将排好序的数组重新赋值给原数组
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
        }
    }

    public static void radixSort(int[] a) {
        int exp;
        int max = getMax(a);

        // 从个位开始对数组按exp进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }
}
