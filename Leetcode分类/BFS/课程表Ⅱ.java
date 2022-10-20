package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/10/20 11:04
 * @File: 课程表Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode210
// https://leetcode.cn/problems/course-schedule-ii/

public class 课程表Ⅱ {
    // 和课程表一样，不过需要记录课程顺序而已
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        // 更新每个节点的入度和邻接表
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adj[cp[1]].add(cp[0]);
        }
        // 保存入度为0的节点
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            // 如果节点入度为0，就将该点加入到队列中
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        // 记录入度为0的节点数目
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[count++] = cur;  // 记录当前入度为0的节点
            HashSet<Integer> link = adj[cur];
            for (int next : link) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        // 如果所有课程的入度都为0了就符合条件
        return count == numCourses ? result : new int[0];
    }
}
