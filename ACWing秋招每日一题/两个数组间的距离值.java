
/**
 * @author psj
 * @date 2022/9/24 22:07
 * @File: 两个数组间的距离值.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1385
public class 两个数组间的距离值 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        for (int num1 : arr1) {
            boolean flag = true;
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }
}
