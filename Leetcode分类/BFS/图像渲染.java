package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/10/22 10:32
 * @File: 图像渲染.java
 * @Software: IntelliJ IDEA
 */
// Leetcode733
// https://leetcode.cn/problems/flood-fill/

public class 图像渲染 {
    // 该问题就是一个岛屿问题
    // 不需要使用visited数组是因为在判断条件中有颜色相等判断，
    // 达到过的位置因为已经被赋值了相同颜色，所以不会在重复遍历

    // 方法1：BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int cur = image[sr][sc];
        if (cur == color) {
            return image;
        }
        int row = image.length;
        int col = image[0].length;
        // 存储可以到达的位置
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            // 往四个方向扩散
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                // 扩散条件是即将扩散的位置在合理范围内，并且和当前位置的颜色一致
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && image[nx][ny] == cur) {
                    queue.offer(new int[]{nx, ny});
                    image[nx][ny] = color;
                }
            }
        }
        return image;
    }

    // 方法2：DFS
    int[][] dire = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill_dfs(int[][] image, int sr, int sc, int color) {
        int cur = image[sr][sc];
        if (cur != color) {
            dfs(image, sr, sc, cur, color);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int cur, int color) {
        if (image[x][y] == cur) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int nx = x + dire[i][0];
                int ny = y + dire[i][1];
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length){
                    dfs(image, nx, ny, cur, color);
                }
            }
        }
    }
}
