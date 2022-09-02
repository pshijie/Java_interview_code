package BackTrace;

/**
 * @author psj
 * @date 2022/7/30 11:53
 * @File: BM57岛屿数量.java
 * @Software: IntelliJ IDEA
 */
public class BM57岛屿数量 {
    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遇到'1'就result+1(因为后续会将周围的'1'置为'0'，所以不会重复遍历)
                if (grid[i][j] == '1') {
                    result++;
                    // 将与该位置相邻的1全部置为0
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return result;
    }

    // 将(i,j)周围的'1'全部置为'0'
    public void dfs(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, m, n, i - 1, j);
        dfs(grid, m, n, i + 1, j);
        dfs(grid, m, n, i, j - 1);
        dfs(grid, m, n, i, j + 1);
    }
}
