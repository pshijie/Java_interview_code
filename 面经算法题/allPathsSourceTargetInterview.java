import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/8/19 11:58
 * @File: allPathsSourceTargetInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 797
// 给一个有n个节点的有向无环图（DAG），请找出所有从节点0到节点n-1的路径并输出
public class allPathsSourceTargetInterview {
    List<List<Integer>> result;
    List<Integer> temp;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        result = new ArrayList<>();
        temp = new ArrayList<>();
        // 起始点确定为0
        temp.add(0);
        dfs(0, n, graph,temp, result);
        return result;
    }

    public void dfs(int index, int n, int[][] graph, List<Integer> temp, List<List<Integer>> result) {
        if (index == n - 1) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int next : graph[index]) {
            temp.add(next);
            // 这里不是index+1，而是下一个能达到的点
            dfs(next, n, graph, temp, result);
            temp.remove(temp.size()-1);
        }
    }

}
