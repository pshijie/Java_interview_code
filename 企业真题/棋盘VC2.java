import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/13 11:37
 * @File: 棋盘VC2.java
 * @Software: IntelliJ IDEA
 */
public class 棋盘VC2 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int m;
    static int[][] aij;
    static int[][] bij;
    static int[][] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        aij = new int[n][m];
        bij = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                aij[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bij[i][j] = sc.nextInt();
            }
        }

        boolean[][] vis = new boolean[n][m];
        result = new int[n][m];

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(dfs(x, y, result, aij, bij, vis));
        }
    }

    private static int dfs(int x, int y, int[][] result, int[][] aij, int[][] bij, boolean[][] vis) {
        if (vis[x][y]) {
            return result[x][y];
        }

        vis[x][y] = true;

        result[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i][0];
            int ny = x + dirs[i][1];
            if (nx < 0 || nx > n || ny < 0 || ny > m) {
                continue;
            }
            if (aij[nx][ny] + bij[nx][ny] <= aij[x][y]) {
                result[x][y] = dfs(nx, ny, result, aij, bij, vis);
            }
        }

        result[x][y] %= 100007;
        return result[x][y];
    }
}
