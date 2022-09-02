/**
 * @author psj
 * @date 2022/8/24 23:29
 * @File: 选择排序.java
 * @Software: IntelliJ IDEA
 */
public class 选择排序 {
    public void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }
}
