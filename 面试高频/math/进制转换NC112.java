package math;

/**
 * @author psj
 * @date 2022/9/17 9:23
 * @File: 进制转换NC112.java
 * @Software: IntelliJ IDEA
 */
public class 进制转换NC112 {
    public String solve(int M, int N) {
        StringBuffer sb = new StringBuffer();
        boolean negNum = false;
        if (M < 0) {
            negNum = true;
            M = -M;
        }
        while (M != 0) {
            int carry = M % N;
            String append = "";
            if (carry >= 10) {
                append = String.valueOf((char) (carry - 10 + 'A'));
            } else {
                append = String.valueOf(carry);
            }

            sb.append(append);
            M /= N;
        }

        if (negNum) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
