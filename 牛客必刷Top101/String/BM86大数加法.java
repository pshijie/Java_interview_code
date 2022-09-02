package String;

/**
 * @author psj
 * @date 2022/8/12 11:35
 * @File: BM86大数加法.java
 * @Software: IntelliJ IDEA
 */
public class BM86大数加法 {
    public String solve(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return s.length() == 0 ? s : t;
        }
        int i = s.length() - 1, j = t.length() - 1;
        int temp = 0;
        StringBuilder result = new StringBuilder();
        // 注意:即使两个字符串都遍历完了，如果存在进位还是需要执行循环代码
        while (i >= 0 || j >= 0 || temp != 0) {
            temp += i >= 0 ? s.charAt(i) - '0' : 0;
            i--;
            temp += j >= 0 ? t.charAt(j) - '0' : 0;
            j--;
            result.append(temp % 10);
            temp = temp / 10;  // 进位
        }
        return result.reverse().toString();
    }
}
