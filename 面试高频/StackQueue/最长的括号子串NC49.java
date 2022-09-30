package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/30 9:11
 * @File: 最长的括号子串NC49.java
 * @Software: IntelliJ IDEA
 */
public class 最长的括号子串NC49 {
    public int longestValidParentheses(String s) {
        int result = 0;
        // 记录上一次连续括号结束的位置
        int start = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 左括号入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
                // 当前准备入栈的为右括号
            } else {
                // 入右括号时栈为空，说明不合法，更新上一次连续括号结束的位置
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    // 弹出左括号
                    stack.pop();
                    // 栈中还有左括号,则当前括号长度为i - stack.peek()
                    if (!stack.isEmpty()) {
                        result = Math.max(result, i - stack.peek());
                    } else {
                        // 栈中没有左括号了，说明连续合法的括号串中断
                        result = Math.max(result, i - start);
                    }
                }
            }
        }
        return result;
    }
}
