package DoublePointer;

/**
 * @author psj
 * @date 2022/8/12 11:44
 * @File: BM87合并两个有序的数组.java
 * @Software: IntelliJ IDEA
 */
public class BM87合并两个有序的数组 {
    // 不使用额外数组
    public void merge(int A[], int m, int B[], int n) {
        // 将两个指针分别指向两个数组有元素的末尾
        int i = m - 1;
        int j = n - 1;
        // *因为A数组末尾处是空的，可直接插入*
        int k = m + n - 1;
        // 将较大的元素放在A数组末尾
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        // 如果B数组还未遍历完
        while (j >= 0) {
            A[k--] = B[j--];
        }
        // 如果A数组未遍历完，无需操作，因为最终结果数组就是A
    }
}
