package BackTrace;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/8/2 11:01
 * @File: BM60括号生成.java
 * @Software: IntelliJ IDEA
 */
public class BM60括号生成 {
    ArrayList<String> result;
    StringBuilder temp;

    public ArrayList<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        temp = new StringBuilder();
        backTrace(n, n);
        return result;
    }

    // left和right分别表示剩余的左括号和右括号
    public void backTrace(int left, int right) {
        // 如果剩余左括号多于右括号，则不合法
        if (left > right) {
            return;
        }
        // 剩余的左/右括号数量小于0，则不合法
        if (left < 0 || right < 0) {
            return;
        }
        // 括号都用完，则符合条件
        if (left == 0 && right == 0) {
            result.add(temp.toString());
            return;
        }
        // 尝试放一个左括号
        temp.append('(');
        backTrace(left - 1, right);
        temp.deleteCharAt(temp.length() - 1);

        // 尝试放一个右括号
        temp.append(')');
        backTrace(left, right - 1);
        temp.deleteCharAt(temp.length() - 1);

    }
}
