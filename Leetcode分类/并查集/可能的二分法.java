package 并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/10 10:34
 * @File: 可能的二分法.java
 * @Software: IntelliJ IDEA
 */
// Leetcode886
// https://leetcode.cn/problems/possible-bipartition/

public class 可能的二分法 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0) {
            return true;
        }
        // 构建邻接表
        List<Integer>[] graph = new ArrayList[n];
        for (int[] dislike : dislikes) {
            if (graph[dislike[0] - 1] == null) {
                graph[dislike[0] - 1] = new ArrayList<>();
            }
            graph[dislike[0] - 1].add(dislike[1] - 1);
        }
        for (int i = 0; i < n; i++) {
            if (graph[i] == null) {
                continue;
            }
            for (int j : graph[i]) {
                if (graph[j] == null) {
                    graph[j] = new ArrayList<>();
                }
                graph[j].add(i);
            }
        }

        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < n; i++) {
            List<Integer> dis = graph[i];
            if (dis == null) {
                continue;
            }
            for (int e : dis) {
                // 当前节点和不喜欢的节点在一个簇中，则不满足条件
                if (uf.isConnected(i, e)) {
                    return false;
                } else {
                    // 将当前节点不喜欢的节点归到一个簇中
                    uf.union(dis.get(0), e);
                }
            }
        }
        return true;
    }

    // 并查集
    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            // 将祖先节点初始化为自己
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
