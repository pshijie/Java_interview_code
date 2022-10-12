package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/12 9:42
 * @File: 跳跃游戏Ⅲ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode1306
// https://leetcode.cn/problems/jump-game-iii/

public class 跳跃游戏Ⅲ {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int curPos, boolean[] visited) {
        // 如果当前位置越界或者已经被访问过
        if (curPos < 0 || curPos >= arr.length || visited[curPos]) {
            return false;
        }
        if (arr[curPos] == 0) {
            return true;
        }

        visited[curPos] = true;
        return dfs(arr, curPos - arr[curPos], visited)
                || dfs(arr, curPos + arr[curPos], visited);
        // 没有必要回溯，因为如果之前已经到这个点，后续到这个点也是走相同的路径
    }
}
