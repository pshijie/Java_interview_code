package BinarySearch;

/**
 * @author psj
 * @date 2022/7/16 9:31
 * @File: BM20数组中的逆序对.java
 * @Software: IntelliJ IDEA
 */
public class BM20数组中的逆序对 {
    int count = 0;

    public int InversePairs(int[] array) {
        merge(array, 0, array.length - 1);
        return count;
    }

    public void merge(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            merge(array, left, mid);
            merge(array, mid + 1, right);
            mergeSort(array, left, mid, right);
        }

    }

    public void mergeSort(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int m1 = left, m2 = mid + 1;
        while (m1 <= mid && m2 <= right) {
            if (array[m1] <= array[m2]) {
                temp[index++] = array[m1++];
            } else {
                // 执行到该步说明array[m1]以及后续数要比array[m2]大
                // 统计此时的左子数组还剩余几位数没有遍历
                count += (mid - m1 + 1);
                count = count % 1000000007;
                temp[index++] = array[m2++];
            }
        }
        while (m1 <= mid) {
            temp[index++] = array[m1++];
        }
        while (m2 <= right) {
            temp[index++] = array[m2++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }
}
