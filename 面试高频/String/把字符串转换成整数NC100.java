package String;

/**
 * @author psj
 * @date 2022/9/21 9:27
 * @File: 把字符串转换成整数NC100.java
 * @Software: IntelliJ IDEA
 */
public class 把字符串转换成整数NC100 {
    public int StrToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int result = 0;
        int n = s.length();
        int index = 0;

        // 去除前面的空格
        while (index < n) {
            if (s.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }

        // 除去符号后没有内容了
        if (index == n) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            index++;
            sign = -1;
        }

        // 除去符号后没有内容了
        if (index == n) {
            return 0;
        }

        while (index < n) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            // 先判断未进行处理的result*10后是否会大于或小于整型的范围(因为result*10可能会越界，所以改为范围/10)
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && (c - '0') > -Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + sign * (c - '0');
            index++;
        }
        return result;
    }
}
