package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/7 10:12
 * @File: 用两个栈实现队列NC76.java
 * @Software: IntelliJ IDEA
 */
public class 用两个栈实现队列NC76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
