package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/23 10:04
 * @File: BM44有效括号序列.java
 * @Software: IntelliJ IDEA
 */
public class BM44有效括号序列 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s == "" || s.length() % 2 != 0) {
            return false;
        }
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);  // c为当前准备push的元素
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 执行到该步说明当前要push进来是右括号
                // 如果栈为空则push后肯定不合法
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                // 当前push进入的右括号和栈顶不对应则不合法
                if ((pop == '(' && c != ')') ||
                        (pop == '[' && c != ']') ||
                        (pop == '{' && c != '}')) {
                    return false;
                }
            }
            index++;
        }
        return stack.isEmpty();
    }
}
