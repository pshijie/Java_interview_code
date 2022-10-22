package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/10/22 10:20
 * @File: 钥匙和房间.java
 * @Software: IntelliJ IDEA
 */
// Leetcode841
// https://leetcode.cn/problems/keys-and-rooms/

public class 钥匙和房间 {
    // 方法1：BFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;  // 已经达到房间的个数
        // 记录哪些房间已经去过
        boolean[] visited = new boolean[n];
        // 存储当前能够达到的房间
        Queue<Integer> queue = new LinkedList<>();
        // 初始位于0号
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            num++;
            // 遍历当前能够达到的房间
            for (int adj : rooms.get(cur)) {
                // 该房间之前没有遍历过，则加入队列并标记
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }
        return num == n;
    }

    // 方法2：DFS
    boolean[] visited;
    int num;  // 已经达到房间的个数

    public boolean canVisitAllRooms_bfs(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int cur) {
        visited[cur] = true;
        num++;
        for (int adj : rooms.get(cur)) {
            if (!visited[adj]) {
                dfs(rooms, adj);
            }
        }
    }
}
