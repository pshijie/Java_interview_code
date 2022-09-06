package StackQueue;

/**
 * @author psj
 * @date 2022/9/6 10:22
 * @File: 寻找第K大NC88.java
 * @Software: IntelliJ IDEA
 */
public class 寻找第K大NC88 {
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    int quickSort(int[] a, int left, int right, int k) {
        int p = partition(a, left, right);
        if (p == a.length - k) {
            return a[p];
        } else if (p > a.length - k) {
            return quickSort(a, left, p - 1, k);
        } else {
            return quickSort(a, p + 1, right, k);
        }
    }

    int partition(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            if (left == right) {
                break;
            } else {
                a[left] = a[right];
            }

            while (left < right && a[left] <= temp) {
                left++;
            }
            if (left == right) {
                break;
            } else {
                a[right] = a[left];
            }
        }

        a[left] = temp;
        return left;
    }

}
