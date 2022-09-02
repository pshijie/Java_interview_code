package StackQueue;

/**
 * @author psj
 * @date 2022/7/24 10:27
 * @File: BM47寻找第K大.java
 * @Software: IntelliJ IDEA
 */
public class BM47寻找第K大 {
    // 快排每次确定一个最终位置
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, a.length - 1, K);
    }

    // 确定在arr[left...right]中第k大的元素所在下标
    public int quickSort(int[] arr, int left, int right, int k) {
        // p表示当前确定的位置下标
        int p = partition(arr, left, right);
        if (p == arr.length - k) {
            return arr[p];
            // 当前确定顺序的下标在最终位置的左侧
        } else if (p < arr.length - k) {
            return quickSort(arr, p + 1, right, k);
        } else {
            return quickSort(arr, left, p - 1, k);
        }
    }

    // 快排中确定arr[left]在arr中最终位置
    public int partition(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            // 从右向左遍历，找到比当前left位置小的元素并和left交换
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            // 从左向右遍历，找到比当前right位置大的元素并和right交换
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
}
