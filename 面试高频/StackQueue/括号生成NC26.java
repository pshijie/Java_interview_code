package StackQueue;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/9/25 10:17
 * @File: 括号生成NC26.java
 * @Software: IntelliJ IDEA
 */
public class 括号生成NC26 {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        String temp = "";
        recursion(0, 0, temp, result, n);
        return result;
    }

    // left表示已使用的左括号数目，right表示已使用的右括号数目
    private void recursion(int left, int right, String temp, ArrayList<String> result, int n) {
        if (left == n && right == n) {
            result.add(temp);
            return;
        }
        // 使用左括号
        if (left < n) {
            recursion(left + 1, right, temp + "(", result, n);
        }

        // 使用右括号(要保证剩余右括号的数目大于左括号)
        if (right < n && left > right) {
            recursion(left, right + 1, temp + ")", result, n);
        }
    }
}
