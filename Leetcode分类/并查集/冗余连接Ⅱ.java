package 并查集;

/**
 * @author psj
 * @date 2022/10/17 11:19
 * @File: 冗余连接Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode685
// https://leetcode.cn/problems/redundant-connection-ii/

public class 冗余连接Ⅱ {
    // 和冗余连接不同之处在于这里每条边都是有向边
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        int[] parent = new int[n + 1];
        // 初始化每个节点的根节点为自己
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int inNode = edge[0];
            int outNode = edge[1];
            // 如果出度节点存在根节点
            if (parent[outNode] != outNode) {
                conflict = i;
                // 如果出度节点还是单独的节点
            } else {
                parent[outNode] = inNode;
                // 如果两个节点的根节点一样，说明存在环
                if (uf.findRoot(inNode) == uf.findRoot(outNode)) {
                    cycle = i;
                } else {
                    uf.union(inNode, outNode);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 将节点x和y归为一个簇
        public void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if (xRoot != yRoot) {
                parent[xRoot] = yRoot;
            }
        }

        // 查找节点x的根节点
        public int findRoot(int x) {
            if (x != parent[x]) {
                parent[x] = findRoot(parent[x]);
            }
            return parent[x];
        }
    }
}
