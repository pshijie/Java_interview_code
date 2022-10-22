package BFS;

import java.util.LinkedList;

/**
 * @author psj
 * @date 2022/10/22 10:07
 * @File: 不邻接植花.java
 * @Software: IntelliJ IDEA
 */
// Leetcode1042
// https://leetcode.cn/problems/flower-planting-with-no-adjacent/

public class 不邻接植花 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] result = new int[n];
        LinkedList<Integer>[] adj = new LinkedList[n + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
        // 构建邻接表
        for (int[] path : paths) {
            adj[path[0]].add(path[1]);
            adj[path[1]].add(path[0]);
        }
        for (int i = 1; i <= n; i++) {
            // 有4个花色1-4，但是初始花色为0号
            boolean[] color = new boolean[5];
            for (int id : adj[i]) {
                // 将当前邻接点使用过的花色标记，当前节点i不能再使用
                color[result[id - 1]] = true;
            }
            // 寻找剩余的可用种类
            for (int j = 1; j <= 4; j++) {
                if (!color[j]) {
                    result[i - 1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
