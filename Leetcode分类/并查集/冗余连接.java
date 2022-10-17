package 并查集;

/**
 * @author psj
 * @date 2022/10/17 11:03
 * @File: 冗余连接.java
 * @Software: IntelliJ IDEA
 */
// Leetcode684
// https://leetcode.cn/problems/redundant-connection/

public class 冗余连接 {
    // 除了构建并查集外，关键点在于结果是遍历所有边后最后产生的result
    // 结果集
    int[] result = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        // 初始化每个节点的根节点为自己
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent);
        }
        // 需要的是遍历所有边后最后产生的result
        return result;
    }

    // 查找节点x的根节点
    public int findRoot(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = findRoot(parent[x], parent);
        }
        return parent[x];
    }

    // 合并两个不在同一个簇的节点啊
    public void union(int x, int y, int[] parent) {
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        } else {
            // 如果两个点已经存在连接，则更新结果集
            result[0] = x;
            result[1] = y;
        }
    }
}
