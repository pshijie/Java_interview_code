package 前缀;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/4 11:25
 * @File: 字典序排数.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 386
// https://leetcode.cn/problems/lexicographical-numbers/

public class 字典序排数 {
    // 方法1:使用字典序的第K小数字中的解法
    //                      1                      2            .....
    //         10           11           12...
    //     100 101 ...   110 111 ...   120 121 ...
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(findKthNumber(n, i));
        }
        return result;
    }

    int findKthNumber(int n, int k) {
        int pre = 1;  // 表示当前的前缀，比如1，10，11的前缀都是1
        k--;  // 如果找第1个数，在字典序中就是数字1，则可以不必执行下面的while循环
        while (k > 0) {
            // 假设pre=1，则count表示前缀为1的数在n中有多少个
            int cur = count(n, pre, pre + 1);
            if (k >= cur) {  // 寻找的数不在当前前缀区间中
                pre++;
                k -= cur;
            } else {  // 寻找的数在当前前缀区间中
                pre *= 10;  // 可以视为到树的下一层
                k--;
            }
        }
        return pre;
    }

    int count(int n, long x, long y) {
        int sum = 0;
        while (x <= n) {
            sum += Math.min(n + 1, y) - x;  // 比如n=15,sum+=min(16,20)-10;
            x *= 10;
            y *= 10;
        }
        return sum;
    }

    // 方法2:N叉树前序遍历
    List<Integer> result = new ArrayList<>();

    public List<Integer> lexicalOrder_NTree(int n) {
        for (int i = 1; i < 10; i++) {
            dfs(n, i);  // 1~9每个数字都是一个前缀树
        }
        return result;
    }

    void dfs(int n, int cur) {
        if (cur > n) {
            return;
        }
        result.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(n, cur * 10 + i);  // 继续往下一层遍历
        }
    }
}