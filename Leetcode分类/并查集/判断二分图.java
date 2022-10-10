package 并查集;

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
    // 方法1:dfs
    // 相邻顶点染成相反的颜色。
    // 这个过程中发现相邻的顶点被染成了相同的颜色，说明它不是二分图；反之，如果所有的连通域都染色成功，说明它是二分图
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite_dfs(int[][] graph) {
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

    // 方法2：并查集
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int[] agjArr = graph[i];
            // 与可能的二分法类似，将相邻的点视为不喜欢的点，这些不喜欢的点归为一簇
            for (int j = 1; j < agjArr.length; j++) {
                uf.union(agjArr[0], agjArr[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            int rootI = uf.find(i);
            int[] adjArr = graph[i];
            for (int j : adjArr) {
                // 如果当前点和不喜欢的点在一簇，则不符合要求
                if (uf.find(j) == rootI) {
                    return false;
                }
            }
        }
        return true;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 如果两个节点属于不同的祖先，将其归为一簇
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);

            if (rootx != rooty) {
                parent[rooty] = rootx;
            }
        }

        // 找到x的祖先节点
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // 判断两个节点是否在一个簇中
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
