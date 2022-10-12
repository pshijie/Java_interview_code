package BFS;

import java.util.*;

/**
 * @author psj
 * @date 2022/10/12 9:49
 * @File: 跳跃游戏4.java
 * @Software: IntelliJ IDEA
 */
// Leetcode1345
// https://leetcode.cn/problems/jump-game-iv/

public class 跳跃游戏Ⅳ {
    // 最后一个数所在层数为0，第一层就是挨着它的元素以及值和它相等的那些数，第二层就是第一层挨着的元素以及值和第一层元素相等的那些数...按层次依次往上加
    // 题目要求最少操作数，对于"挨着它的元素"如果前面已经求出了距离(层数)，这时就不用再去算了，因为+1之后结果只会更大
    // 其实就是一层一层往下找，知道找到第一个元素
    final static int MAX = Integer.MAX_VALUE;

    public int minJumps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        // 记录已经计算过到最后一个元素距离的元素下标
        Queue<Integer> queue = new LinkedList<>();
        // 记录每个值对应的数组下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(i);
            map.put(a, list);
        }
        int[] dis = new int[n];  // 记录每个元素到最后一个元素的距离
        Arrays.fill(dis, MAX);
        dis[n - 1] = 0;  // 最后一个元素到自身距离为0

        queue.offer(n - 1);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            // x左边的元素还未计算过到最后一个元素的距离
            if (x - 1 >= 0 && dis[x - 1] == MAX) {
                dis[x - 1] = dis[x] + 1;
                queue.offer(x - 1);
            }
            // x右边的元素还未计算过到最后一个元素的距离
            if (x + 1 < n && dis[x + 1] == MAX) {
                dis[x + 1] = dis[x] + 1;
                queue.offer(x + 1);
            }
            // 不和x相邻,但是值相同的元素且未计算过到最后一个元素的距离
            if (!visited[x]) {
                for (int i : map.get(arr[x])) {
                    if (dis[i] == MAX) {
                        dis[i] = dis[x] + 1;
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }

        return dis[0];
    }
}
