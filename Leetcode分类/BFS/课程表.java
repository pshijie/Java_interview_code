package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/10/20 10:38
 * @File: 课程表.java
 * @Software: IntelliJ IDEA
 */
// Leetcode207
// https://leetcode.cn/problems/course-schedule/

public class 课程表 {
    // 问题视为课程安排表是否为有向无环图，使用拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个节点的入度
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        // 保存入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 更新每个节点的入度和邻接表
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            // 如果节点入度为0，就将该点加入到队列中
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            // 将pre节点移除，就需要将该节点连接的点之间的边都移除，意味着这些节点的入度-1
            for (int cur : adj.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        // 如果最后所有节点的入度都为0，说明课程安排合理
        return numCourses == 0;
    }
}
