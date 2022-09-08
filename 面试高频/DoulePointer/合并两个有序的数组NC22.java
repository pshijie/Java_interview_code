package DoulePointer;

/**
 * @author psj
 * @date 2022/9/8 11:02
 * @File: 合并两个有序的数组NC22.java
 * @Software: IntelliJ IDEA
 */
public class 合并两个有序的数组NC22 {
    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                temp[index++] = A[i++];
            } else {
                temp[index++] = B[j++];
            }
        }

        while (i < m){
            temp[index++] = A[i++];
        }
        while (j < n){
            temp[index++] = B[j++];
        }
        for (int k = 0; k < m + n; k++) {
            A[i] = temp[i];
        }
    }
}
