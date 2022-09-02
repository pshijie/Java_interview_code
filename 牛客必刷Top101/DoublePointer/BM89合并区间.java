package DoublePointer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author psj
 * @date 2022/8/12 11:54
 * @File: BM89合并区间.java
 * @Software: IntelliJ IDEA
 */
public class BM89合并区间 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        // 先根据start进行排序
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int index = 0;
        int len = intervals.size();
        while (index < len) {
            int left = intervals.get(index).start;
            int right = intervals.get(index).end;
            // 如果下一个区间的start在当前区间end左侧
            // 不断扩大存在重叠的区间
            while (index < len - 1 && intervals.get(index + 1).start <= right) {
                right = Math.max(right, intervals.get(index + 1).end);
                index++;
            }
            result.add(new Interval(left, right));
            index++;
        }
        return result;
    }
}
