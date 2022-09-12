/**
 * @author psj
 * @date 2022/9/12 23:06
 * @File: 将数字变成0的操作次数.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1342
public class 将数字变成0的操作次数 {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            result++;
        }
        return result;
    }
}
