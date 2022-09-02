package DynamicProgram;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/8/9 11:30
 * @File: BM77最长的括号子串.java
 * @Software: IntelliJ IDEA
 */
public class BM77最长的括号子串 {
    public int longestValidParentheses(String s) {
        int result = 0;
        int start = -1;  // 记录上一次连续括号结束的位置
        // 记录括号的下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 如果当前是左括号,则记录左括号的下标
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 当前栈为空，则当前遍历到的右括号不合法
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    // 弹出栈顶(注意:栈中存入的元素都是左括号)
                    stack.pop();
                    // 此时栈不为空则说明还有左括号
                    // 因为无法判断等会进入的是否为右括号，所以先记录下当前的长度与result进行比较
                    if (!stack.isEmpty()) {
                        result = Math.max(result, i - stack.peek());
                    } else {
                        // 此时栈为空,当前位置减去记录的起始位置就是当前的长度
                        result = Math.max(result, i - start);
                    }
                }

            }
        }
        return result;
    }
}
