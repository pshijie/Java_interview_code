/**
 * @author psj
 * @date 2022/9/2 11:04
 * @File: Dijkstra算法.java
 * @Software: IntelliJ IDEA
 */

// 单源正权最短路径，固定起点到图中其他所有顶点的最短路径，边权重都是正数
// 过程:贪心
// 首先把起点到所有点的距离存下来找个最短的，然后松弛一次再找出最短的
// 所谓的松弛操作就是遍历一遍看通过刚刚找到的距离最短的点作为中转站会不会更近，如果更近了就更新距离，这样把所有的点找遍之后就存下了起点到其他所有点的最短距离
public class Dijkstra算法 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 3, 6, 10, -1},
                {-1, 0, 2, -1, 1},
                {-1, -1, 0, 3, 1},
                {-1, -1, -1, 0, -1},
                {-1, -1, -1, 1, 0}};
        int[] dis = getShortestPaths(matrix);
        for (int i = 0; i < dis.length; i++) {
            System.out.println(dis[i] + " ");
        }
    }

    private static int[] getShortestPaths(int[][] matrix) {
        // 判断顶点的最短路径是否找到
        boolean[] T = new boolean[matrix.length];
        // 存储起点到各顶点的路径长度
        int[] dis = new int[matrix.length];
        T[0] = true;

        // 初始时起点到其他顶点的路径长度
        for (int i = 0; i < matrix.length; i++) {
            dis[i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;  // 起点到中转点的最短长度
            int k = 0;
            // 遍历每个点，从中找到能达到的点，且未被访问过的中最短的一个
            for (int j = 1; j < matrix.length; j++) {
                if (!T[j] && dis[j] != -1 && dis[j] < min) {
                    min = dis[j];
                    k = j;
                }
            }
            T[k] = true;  // 表示以k作为中转点去遍历每个未找到最短路径的点，更新距离

            for (int j = 1; j < matrix.length; j++) {
                if (!T[j]) {
                    // 看k能到达哪些点,如果因为经过k能降低到目标点的距离，就将起始点到目标点的距离修改
                    if (matrix[k][j] != -1 && (dis[j] > min + matrix[k][j] || dis[j] == -1)) {
                        dis[j] = min + matrix[k][j];
                    }
                }
            }
        }
        return dis;
    }
}
