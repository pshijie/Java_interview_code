package BinarySearch;

/**
 * @author psj
 * @date 2022/7/16 9:52
 * @File: BM21旋转数组的最小数字.java
 * @Software: IntelliJ IDEA
 */
public class BM21旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
                // 当 array[mid] = array[j]时：无法判断mid在哪个排序数组中，
                // 即无法判断旋转点x在[i,mid]还是[mid+1,j]区间中
                // 解决方案：执行right = right - 1缩小判断范围
            } else {
                right = right - 1;
            }
        }
        return array[left];
    }
}
