package String;

/**
 * @author psj
 * @date 2022/9/9 11:21
 * @File: 反转字符串NC103.java
 * @Software: IntelliJ IDEA
 */
public class 反转字符串NC103 {
    public String solve (String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
