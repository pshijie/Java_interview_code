package String;

/**
 * @author psj
 * @date 2022/9/8 11:45
 * @File: 大数加法NC.java
 * @Software: IntelliJ IDEA
 */
public class 大数加法NC {
    public String solve(String s, String t) {
        if (s.length() <= 0) {
            return t;
        }
        if (t.length() <= 0) {
            return s;
        }

        int i = s.length() - 1;
        int j = t.length() - 1;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || temp != 0) {
            temp += i >= 0 ? s.charAt(i--) - '0' : 0;
            temp += j >= 0 ? t.charAt(j--) - '0' : 0;
            sb.append(temp % 10);
            temp = temp / 10;
        }
        return sb.reverse().toString();

    }
}
