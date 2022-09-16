package StackQueue;

import java.util.*;

/**
 * @author psj
 * @date 2022/9/16 10:22
 * @File: 表达式求值NC137.java
 * @Software: IntelliJ IDEA
 */
public class 表达式求值NC137 {
    public ArrayList<Integer> function(String s, int index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        int i;
        for (i = index; i < s.length(); i++) {
            // 判断是否为数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
                if (i != s.length() - 1)
                    continue;
            }
            // 碰到'('时，把整个括号内的当成一个数字处理
            if (s.charAt(i) == '(') {
                // 递归处理括号
                ArrayList<Integer> res = function(s, i + 1);
                num = res.get(0);
                i = res.get(1);
                if (i != s.length() - 1)
                    continue;
            }
            switch (op) {
                // 遇到加减号先将数字入栈，不直接进行计算
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    //相反数
                    stack.push(-num);
                    break;
                // 优先计算乘号
                case '*':
                    int temp = stack.pop();
                    stack.push(temp * num);
                    break;
            }
            num = 0;
            // 右括号结束递归
            if (s.charAt(i) == ')')
                break;
            else
                op = s.charAt(i);
        }
        int sum = 0;
        //栈中元素相加
        while (!stack.isEmpty())
            sum += stack.pop();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(sum);
        temp.add(i);
        return temp;
    }

    public int solve(String s) {
        ArrayList<Integer> res = function(s, 0);
        return res.get(0);
    }

}
