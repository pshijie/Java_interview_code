package 前缀和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/3 10:50
 * @File: 会议室.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 252
// https://leetcode.cn/problems/meeting-rooms/
// 给定一系列的会议时间间隔，包括起始和结束时间，确定一个人是否可以参加所有会议

public class 会议室 {
    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 可以理解为同一个时段最大的同时在用的会议室数目是否为1
    // 和数飞机的前缀和方法一致
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }

        int[] num = new int[1110100];
        int max = 0;
        for (int i = 0; i < intervals.size(); i++) {
            num[intervals.get(i).start]++;
            num[intervals.get(i).end]--;
            max = Math.max(max, intervals.get(i).end);
        }

        int result = 0;
        // 计算出max是为了不完全遍历数组
        for (int i = 0; i <= max; i++) {
            if (i != 0) {
                num[i] += num[i - 1];
            }
            result = Math.max(result, num[i]);
        }
        // 比如[5,9]和[8, 15]，在前缀和计算到num[8]是result的值变为2，说明有重复的区间
        // *result在遍历到第一个区间的start时变为1，如果每个区间都不冲突则result=1会一直保持到最后
        return result == 1 ? true : false;
    }

}
