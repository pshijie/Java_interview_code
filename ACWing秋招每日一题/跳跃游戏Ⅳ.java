import java.util.*;

/**
 * @author psj
 * @date 2022/9/15 23:38
 * @File: 跳跃游戏Ⅳ.java
 * @Software: IntelliJ IDEA
 */
public class 跳跃游戏Ⅳ {
    public int minJumps(int[] arr) {
        // 将arr视为一个无向图，然后使用BFS从0搜索到n-1即可

        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        // 记录相同的值对应的下标集合
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 相当于以前先判断有没有这个key值，没有就创建空集合然后加入，有就直接添加
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 记录访问过的元素
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int result = 0;  // 可以视为树的层数
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == n - 1) {
                    return result;
                }

                // 将和index相连的边入队
                // 1.入队值相同的
                if (map.containsKey(arr[index])) {
                    for (int next : map.get(arr[index])) {
                        if (next != index && !visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                        // 因为等找到下一个相同值的点时，说明已经到下面的层了，不需要在往回走
                        // 直接删除可以不用再进入上面的if判断
                        map.remove(arr[index]);
                    }
                }
                // 2.入队index+1
                if (index + 1 <= n - 1 && !visited[index + 1]) {
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }
                // 3.入队index-1
                if (index - 1 >= 0 && !visited[index - 1]) {
                    queue.offer(index - 1);
                    visited[index + 1] = true;
                }
            }
            result++;
        }
        return -1;
    }
}
