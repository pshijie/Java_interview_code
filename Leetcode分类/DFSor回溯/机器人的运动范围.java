package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/13 10:46
 * @File: 机器人的运动范围.java
 * @Software: IntelliJ IDEA
 */
// 面试题13
// https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        int result = dfs(m, n, k, 0, 0, visited);
        return result;
    }

    // r表示机器人当前的行 c表示机器人当前的列
    private int dfs(int m, int n, int k, int r, int c, boolean[][] visited) {
        // 如果机器人不再合法范围内或者当前位置已经访问过或者坐标位数和大于k
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || cal(r) + cal(c) > k) {
            return 0;
        }
        visited[r][c] = true;
        return dfs(m, n, k, r - 1, c, visited) +
                dfs(m, n, k, r + 1, c, visited) +
                dfs(m, n, k, r, c - 1, visited) +
                dfs(m, n, k, r, c + 1, visited) + 1;
        // 不需要回溯
    }

    // 计算当前数字的位数总和，比如12=1+2=3
    public int cal(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
