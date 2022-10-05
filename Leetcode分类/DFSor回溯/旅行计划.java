package DFSor回溯;

import java.util.HashSet;

/**
 * @author psj
 * @date 2022/10/5 10:35
 * @File: 旅行计划.java
 * @Software: IntelliJ IDEA
 */
// lintcode 1891
// https://www.lintcode.com/problem/1891/

public class 旅行计划 {
    int result = Integer.MAX_VALUE;

    public int travelPlan(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return -1;
        }

        // 记录访问过的点
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        // 从arr[0]看第0个点能到哪些点
        dfs(arr, 0, visited, 0);
        return result;
    }

    // row：当前遍历的arr的行
    private void dfs(int[][] arr, int row, HashSet<Integer> visited, int dist) {
        if (row >= arr.length) {
            return;
        }
        // 所有点都遍历完毕
        if (visited.size() == arr.length) {
            dist += arr[row][0];  // 加上第row个点到第0个点的距离
            if (dist < result) {
                result = dist;
            }
            return;
        }

        // 对于当前层(即arr[col])能到达的点进行遍历
        // 从第1个节点开始遍历
        for (int col = 1; col < arr.length; col++) {
            // 之前到过的不能再次访问
            if (visited.contains(col)) {
                continue;
            }
            // 自己不访问自己
            if (col == row) {
                continue;
            }
            visited.add(col);
            // 遍历到第col个点后，下一层就要遍历第col点的行
            dfs(arr, col, visited, dist + arr[row][col]);
            visited.remove(col);
        }
    }

}
