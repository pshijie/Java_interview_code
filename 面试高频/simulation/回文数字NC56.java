package simulation;

/**
 * @author psj
 * @date 2022/9/30 9:42
 * @File: 回文数字NC56.java
 * @Software: IntelliJ IDEA
 */
public class 回文数字NC56 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            int div = temp % 10;
            // 防止reverse * 10+div溢出
            if (reverse >= Integer.MAX_VALUE / 10 && div > 7) {
                return false;
            }
            reverse = reverse * 10 + div;
            temp = temp / 10;
        }
        return x == reverse;
    }
}
