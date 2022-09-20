package Array;

/**
 * @author psj
 * @date 2022/9/20 9:59
 * @File: 在两个长度相等的排序数组中找到上中位数NC36.java
 * @Software: IntelliJ IDEA
 */
public class 在两个长度相等的排序数组中找到上中位数NC36 {
    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;
        int k = (l1 + l2) / 2;
        int i = 0, j = 0;
        int res = -1;
        while (i < l1 && j < l2 && k >= 1) {
            if (arr1[i] == arr2[j]) {
                res = arr1[i++];
                k--;
            } else if (arr1[i] < arr2[j]) {
                res = arr1[i++];
                k--;
            } else {
                res = arr2[j++];
                k--;
            }
        }
        return res;
    }
}
