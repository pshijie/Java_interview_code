/**
 * @author psj
 * @date 2022/8/25 23:31
 * @File: 希尔排序.java
 * @Software: IntelliJ IDEA
 */
public class 希尔排序 {
    public static void shellSort(int[] a) {
        int n = a.length;
        // gap为步长
        for (int gap = n / 2; gap >= 1; gap /= 2) {
            // 一共有gap组，每组的第一个相当于已经排好序了，所以i从gap开始
            for (int i = gap; i < n; i++) {
                // j+gap为当前要排序的元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (a[j] > a[j + gap]) {
                        swap(a, j + gap, j);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
