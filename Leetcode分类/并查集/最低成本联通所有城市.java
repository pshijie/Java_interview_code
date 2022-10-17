package 并查集;

import java.util.Arrays;

/**
 * @author psj
 * @date 2022/10/17 10:32
 * @File: 最低成本联通所有城市.java
 * @Software: IntelliJ IDEA
 */
// Leetcode1135
// https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
// 有N个城市，从1-N编号。connections[i] = [city1, city2, cost]表示从city1到city2的成本(连接是双向的)
// 返回使得每对城市间都存在将它们连接在一起的连通路径最小成本

public class 最低成本联通所有城市 {
    // Kruskal=贪心+并查集
    // 将所有边按cost从小到大排序，然后使用并查集尝试合并每个边
    // 合并后如果有多个root，则有多个连通分量，不符合要求；否则返回cost
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int[] parent = new int[N + 1];
        // 初始化每个节点的根节点为自己
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for (int[] edge : connections) {
            // 如果两个节点原本不在一个连通分量中，则将这两个节点归为一个连通分量，并且cost加上边的值
            // 如果已经在一个连通分量中，就不需要再加边的值
            if (union(edge[0], edge[1], parent)) {
                cost += edge[2];
            }
        }
        int p = -1;
        // 判断整个图有几个连通分量
        for (int i = 1; i <= N; i++) {
            int root = findRoot(i, parent);
            // 第一个节点视为root
            if (p == -1) {
                p = root;
                // 如果p!=root说明出现1个以上的连通分量
            } else if (p != root) {
                return -1;
            }
        }
        return cost;
    }

    // 找到x的根节点
    public int findRoot(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = findRoot(parent[x], parent);
        }
        return parent[x];
    }

    // 判断节点a和b是否在一个连通分量：在就返回false，不在就归为一个连通分量，并返回true
    public boolean union(int a, int b, int[] parent) {
        a = findRoot(a, parent);
        b = findRoot(b, parent);
        if (a == b) {
            return false;
        }
        parent[a] = b;
        return true;
    }
}
