package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/13 10:34
 * @File: 大容量背包.java
 * @Software: IntelliJ IDEA
 */
// lintcode1382
// https://www.lintcode.com/problem/1382/

public class 大容量背包 {
    long result = Long.MIN_VALUE;

    public long getMaxValue(int s, int[] v, int[] c) {
        for (int i = 0; i < c.length; i++) {
            dfs(s, v, c, i, c[i], v[i]);
        }
        return result;
    }

    // index表示当前遍历到的物品下标  sum表示当前背包容量  value表示当前背包价值
    private void dfs(int s, int[] v, int[] c, int index, int sum, long value) {
        // 检验当前背包容量是否超过最大容量
        if (sum > s) {
            return;
        }
        // 如果当前的价值大于当前最大值
        if (value > result) {
            result = value;
        }

        for (int i = index + 1; i < c.length; i++) {
            dfs(s, v, c, i, sum + c[i], value + (long) v[i]);
        }
    }
}
