package DFSor回溯;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/10/9 11:46
 * @File: 判断二分图.java
 * @Software: IntelliJ IDEA
 */
// Leetcode785
// https://leetcode.cn/problems/is-graph-bipartite/

public class 判断二分图 {
    // 相邻顶点染成相反的颜色。
    // 这个过程中发现相邻的顶点被染成了相同的颜色，说明它不是二分图；反之，如果所有的连通域都染色成功，说明它是二分图
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; ++i) {
            // 如果当前节点未被染色，则将其染为红色
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    public void dfs(int node, int c, int[][] graph) {
        color[node] = c;  // 染色操作
        int cNei = c == RED ? GREEN : RED;  // 如果当前节点是红色则邻居需要染为绿色。绿色则染为红色
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                // 如果邻居还未被染色(还未遍历)，则从邻居开始往下遍历
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
                // 如果邻居已被染色，并且当前的颜色不和当前节点的颜色相反，则不合法
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }

}
