/**
 * @author psj
 * @date 2022/7/21 10:44
 * @File: 冒泡排序.java
 * @Software: IntelliJ IDEA
 */
public class 冒泡排序 {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 最后一个位置(即i=0)不需要判断,因为只剩一个
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
