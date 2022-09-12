package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/12 9:22
 * @File: 包含min函数的栈NC90.java
 * @Software: IntelliJ IDEA
 */
public class 包含min函数的栈NC90 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        if (!s2.isEmpty()) {
            if (node <= s2.peek()) {
                s2.push(node);
            }
        } else {
            s2.push(node);
        }
        s1.push(node);
    }

    public void pop() {
        int pop = s1.pop();
        if (pop == s2.peek()) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
