import java.util.Arrays;

/**
 * @author psj
 * @date 2022/9/24 22:56
 * @File: 将整数按权重排序.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1387
public class 将整数按权重排序 {
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] q = new int[n][2];
        for (int i = lo; i <= hi; i++) {
            q[i - lo][0] = get(i);
            q[i - lo][1] = i;  // 用于步数一样时比较下标
        }
        Arrays.sort(q, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        return q[k - 1][1];
    }

    private int get(int x) {
        int result = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
            }
            result++;
        }
        return result;
    }
}

