package 前缀;

import java.util.Arrays;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/3 11:09
 * @File: 会议室Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 253
// https://leetcode.cn/problems/meeting-rooms-ii/
// 给定一系列的会议时间间隔，包括起始和结束时间，找到所需的最小会议室数

public class 会议室Ⅱ {
    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 方法1:前缀和
    // 可以理解为求同一个时段最大的同时在用的会议室数目
    // 和会议室的方法一致，将结果的返回值修改即可
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        int[] num = new int[1110100];
        int max = 0;
        for (int i = 0; i < intervals.size(); i++) {
            num[intervals.get(i).start]++;
            num[intervals.get(i).end]--;
            max = Math.max(max, num[intervals.get(i).end]);
        }

        int result = 0;
        // 计算出max是为了不完全遍历数组
        for (int i = 0; i <= max; i++) {
            if (i != 0) {
                num[i] += num[i - 1];
            }
            result = Math.max(result, num[i]);
        }
        return result;
    }

    // 方法2:排序后遍历
    public int minMeetingRooms_sort(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        // *将两个数组进行排序
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0, count = 0, result = 0;
        while (i < n) {
            if (start[i] < end[j]) {
                count++;
                i++;
                // 相当于遍历到了下一个未重合的区间
            } else if (start[i] > end[j]) {
                count--;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return result;
    }
}
