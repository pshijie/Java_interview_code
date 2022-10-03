package 贪心;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author psj
 * @date 2022/10/3 11:28
 * @File: 最多可以参加的会议数目.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1353
// https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/

public class 最多可以参加的会议数目 {
    // 在所有开始时间相同的会议中，尽量选择结束时间最小的会议，因为结束时间更大的会议的选择天数更多
    // 比如在会议[[1,1],[1,2],[1,3]]中，如果是在第1天的话，尽量的选择[1,1]，因为后面的两个会议分别可以在第2天和第3天选择
    // 为什么使用小顶堆？
    //  快速的选择结束时间最小的会议，且这个最小的结束时间是动态变化的，因为参加了一个会议，就应该排除这个会议
    // 思想：
    // 1.对会议按照开始时间升序排列
    // 2.然后从第1天开始，依次判断每一天是否可以参加会议，记当天为currDay
    // 3.顺序遍历会议，将开始时间等于currDay的会议的结束时间放入小顶堆
    // 4.将堆顶结束时间小于currDay的会议从堆中删除(这些会议都是过时的，参加不到的会议)
    // 5.如果堆不为空，则选择会议结束时间最小的会议参加，表示currDay这一天可以参加会议
    // 6.currDay往后走一天，判断下一天是否可以参加会议

    public int maxEvents(int[][] events) {
        int n = events.length;
        // 按开始时间进行排序
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        int currDay = 1;
        int i = 0;
        while (i < n || !pq.isEmpty()) {
            // 将所有开始时间等于currDay的会议的结束时间放到小顶堆
            while (i < n && events[i][0] == currDay) {
                pq.add(events[i][1]);
                i++;
            }

            // 将已经结束的会议弹出堆中，即堆顶的结束时间小于currDay的
            while (!pq.isEmpty() && pq.peek() < currDay) {
                pq.remove();
            }
            // 贪心的选择结束时间最小的会议参加
            if (!pq.isEmpty()) {
                // 参加的会议，就从堆中删除
                pq.remove();
                result++;
            }

            // 当前的天往前走一天，开始看下下一天能不能参加会议
            currDay++;
        }


        return result;
    }
}
