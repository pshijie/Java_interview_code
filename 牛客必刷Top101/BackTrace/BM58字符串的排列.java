package BackTrace;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/7/30 12:05
 * @File: BM58字符串的排列.java
 * @Software: IntelliJ IDEA
 */
public class BM58字符串的排列 {
    ArrayList<String> result;
    boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return result;
        }
        result = new ArrayList<>();
        visited = new boolean[str.length()];
        char[] charStr = str.toCharArray();
        Arrays.sort(charStr);  // 先排序*
        Arrays.fill(visited, false);
        StringBuffer temp = new StringBuffer();
        backTrace(charStr, temp);
        return result;
    }

    public void backTrace(char[] charStr, StringBuffer temp) {
        if (temp.length() == charStr.length) {
            result.add(new String(temp));
            return;
        }
        for (int i = 0; i < charStr.length; i++) {
            // 该元素已经被加入到temp中
            if (visited[i]) {
                continue;
            }
            // 当前的元素charStr[i]与同一层的前一个元素charStr[i-1]相同且charStr[i-1]已经用过了
            if (i > 0 && charStr[i - 1] == charStr[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.append(charStr[i]);

            backTrace(charStr, temp);

            temp.deleteCharAt(temp.length() - 1);
            visited[i] = false;
        }
    }
}
