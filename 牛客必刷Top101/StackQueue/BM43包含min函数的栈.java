package StackQueue;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/23 9:49
 * @File: BM43包含min函数的栈.java
 * @Software: IntelliJ IDEA
 */
public class BM43包含min函数的栈 {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();  // 存储最小值

    public void push(int node) {
        s1.push(node);
        if (!s2.isEmpty()) {
            // 注意条件是小于等于，如果直接写小于会报错
            // 因为如果有连续多个最小值push进来,而stack2只会存储一个，则pop时会出错
            if (node <= s2.peek()) {
                s2.push(node);
            }
        } else {
            s2.push(node);
        }

    }

    public void pop() {
        int popValue = s1.pop();
        if (popValue == s2.peek()) {
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
