package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/23 9:43
 * @File: BM42用两个栈实现队列.java
 * @Software: IntelliJ IDEA
 */
public class BM42用两个栈实现队列 {
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
