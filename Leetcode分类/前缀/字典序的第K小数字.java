package 前缀;

/**
 * @author psj
 * @date 2022/10/4 11:03
 * @File: 字典序的第K小数字.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 440
// https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/

public class 字典序的第K小数字 {
    //                      1                      2            .....
    //         10           11           12...
    //     100 101 ...   110 111 ...   120 121 ...
    public int findKthNumber(int n, int k) {
        int pre = 1;  // 表示当前的前缀，比如1，10，11的前缀都是1
        k--;  // 如果找第1个数，在字典序中就是数字1，则可以不必执行下面的while循环
        while (k > 0) {
            // 假设pre=1，则count表示前缀为1的数在n中有多少个
            int cur = count(n, pre, pre + 1);
            if (k >= cur) {  // 寻找的数不在当前前缀区间中
                pre++;  // 相等于到同一层的旁边子树
                k -= cur;
            } else {  // 寻找的数在当前前缀区间中
                pre *= 10;
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

}
