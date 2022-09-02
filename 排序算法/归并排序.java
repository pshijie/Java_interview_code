/**
 * @author psj
 * @date 2022/8/21 17:19
 * @File: 归并排序.java
 * @Software: IntelliJ IDEA
 */
public class 归并排序 {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                help[index] = arr[p1];
                p1++;
            } else {
                help[index] = arr[p2];
                p2++;
            }
            index++;

        }

        while (p1 <= mid){
            help[index++] = arr[p1++];
        }
        while (p2 <= right){
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}
