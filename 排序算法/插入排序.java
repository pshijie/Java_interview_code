/**
 * @author psj
 * @date 2022/8/23 23:06
 * @File: 插入排序.java
 * @Software: IntelliJ IDEA
 */
public class 插入排序 {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] > arr[j]) {
                    swap(arr, j + 1, j);
                } else {
                    break;
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
