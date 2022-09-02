/**
 * @author psj
 * @date 2022/8/2 11:57
 * @File: 快速排序.java
 * @Software: IntelliJ IDEA
 */
public class 快速排序 {
    public int[] MySort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i, j, dummy;
            i = l;
            j = r;
            dummy = a[i];  // 哨兵,即每轮数组的第一个元素
            while (i < j) {
                while (i < j && a[j] > dummy) {
                    j--;  // 从右向左找到第一个小于dummy的数
                }
                // 因为跳出上述while循环的条件有两个,需要判断是否是因为i>j跳出
                if (i < j) {
                    a[i] = a[j];
//                    i++;  // 这里加1后如果i=j就无需进行下面的判断(不加也可)
                }
                while (i < j && a[i] < dummy) {
                    i++;  // 从左向右找到第一个大于dummy的数
                }
                // 因为跳出上述while循环的条件有两个,需要判断是否是因为i>j跳出
                if (i < j) {
                    a[j] = a[i];
//                    j--;  // 这里减1后如果i=j就无需进行后续的判断(不加也可)
                }
            }
            a[i] = dummy;  // 将哨兵赋值给i位置,此时确定了第i个元素的位置
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);

        }
    }
}
