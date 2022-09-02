package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author psj
 * @date 2022/8/14 12:25
 * @File: BM96主持人调度Ⅱ.java
 * @Software: IntelliJ IDEA
 */
public class BM96主持人调度Ⅱ {
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        int[][] c = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = startEnd[i][j];
            }
        }
        // 将数组依次开始时间和结束时间排序
        Arrays.sort(c, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] < y[1] ? -1 : (x[1] == y[1] ? 0 : 1);
            } else {
                return x[0] < y[0] ? -1 : (x[0] == y[0] ? 0 : 1);
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(c[0][1]); //压入第一个活动的结束时间
        for (int i = 1; i < n; i++) {
            // 如果后面的活动的开始时间比前面的活动的结束时间后，则表示可以由同一个主持人主持
            if (c[i][0] >= priorityQueue.peek()) {
                priorityQueue.poll();  // 弹出当前活动的结束时间
            }
            priorityQueue.offer(c[i][1]);  // 压入当前活动的后一个活动的结束时间
        }

        return priorityQueue.size();  // 返回优先队列的大小即为最小的主持人数量

    }
}
