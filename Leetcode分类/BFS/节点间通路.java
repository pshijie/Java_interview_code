package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/17 10:11
 * @File: 节点间通路.java
 * @Software: IntelliJ IDEA
 */
// 面试题04.01
// https://leetcode.cn/problems/route-between-nodes-lcci/

public class 节点间通路 {
    // 方法1：BFS
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 将矩阵转换为邻接表
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }
        return BFS(n, adj, start, target);
    }

    private boolean BFS(int n, List<Integer>[] adj, int start, int target) {
        // 从start开始遍历，遍历路径上的节点入队
        LinkedList<Integer> queue = new LinkedList<>();
        // 已经入列的节点置为true
        boolean[] visited = new boolean[n];

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 从队列中取节点得到新的可访问链表，对链表上的可访问节点中判断是否有target
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                if (nextList == null) {
                    continue;
                }
                for (int next : nextList) {
                    // 遍历过程中有target则返回true, 否则返回false
                    if (next == target) {
                        return true;
                    }
                    // 已经在队列中的节点是访问过的，不需要再次入队
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }

    // 方法2：DFS
    public boolean findWhetherExistsPath_dfs(int n, int[][] graph, int start, int target) {
        // 将矩阵转换为邻接表
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }
        HashSet<Integer> visited = new HashSet<>();
        return dfs(adj, start, target, visited);
    }

    private boolean dfs(List<Integer>[] adj, int start, int target, HashSet<Integer> visited) {
        List<Integer> neighbor = adj[start];
        if (neighbor == null) {
            return false;
        }
        for (int n : neighbor) {
            if (n == target) {
                return true;
            }
            if (visited.contains(n)) {
                continue;
            }
            visited.add(n);
            if (dfs(adj, n, target, visited)) {
                return true;
            }
            visited.remove(n);
        }
        return false;
    }
}