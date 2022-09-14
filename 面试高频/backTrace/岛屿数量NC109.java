package backTrace;

/**
 * @author psj
 * @date 2022/9/13 10:48
 * @File: 岛屿数量NC109.java
 * @Software: IntelliJ IDEA
 */
public class 岛屿数量NC109 {

    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';


        bfs(grid, i, j + 1, m, n);
        bfs(grid, i, j - 1, m, n);
        bfs(grid, i + 1, j, m, n);
        bfs(grid, i - 1, j, m, n);

    }

}
