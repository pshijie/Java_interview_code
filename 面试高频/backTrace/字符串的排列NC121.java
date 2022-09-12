package backTrace;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/9/12 9:49
 * @File: 字符串的排列NC121.java
 * @Software: IntelliJ IDEA
 */
public class 字符串的排列NC121 {
    ArrayList<String> result;
    boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        visited = new boolean[str.length()];
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuffer sb = new StringBuffer();
        backTrace(chars, sb);
        return result;
    }

    void backTrace(char[] chars, StringBuffer temp) {
        if (temp.length() == chars.length) {
            result.add(new String(temp));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 当前的元素与同一层的前一个元素相同且前个元素已经用过了(使用过了才会将visited[i-1]重新置为false)
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.append(chars[i]);
            backTrace(chars, temp);
            temp.deleteCharAt(temp.length() - 1);
            visited[i] = false;
        }
    }

}
