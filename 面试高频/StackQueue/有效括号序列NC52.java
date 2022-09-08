package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/8 11:18
 * @File: 有效括号序列NC52.java
 * @Software: IntelliJ IDEA
 */
public class 有效括号序列NC52 {
    public boolean isValid(String s) {
        if (s == "" || s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int curIndex = 0;
        while (curIndex < s.length()) {
            char c = s.charAt(curIndex);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if ((pop == '(' && c != ')') ||
                        (pop == '[' && c != ']') ||
                        (pop == '{' && c != '}')) {
                    return false;
                }
            }
            curIndex++;

        }
        return stack.isEmpty();
    }
}
