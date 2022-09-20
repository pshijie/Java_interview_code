package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author psj
 * @date 2022/9/20 9:23
 * @File: 合并区间NC37.java
 * @Software: IntelliJ IDEA
 */
public class 合并区间NC37 {
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
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        result.add(intervals.get(0));
        int count = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval o1 = intervals.get(i);
            Interval origin = result.get(count);
            if (o1.start > origin.end) {
                result.add(o1);
                count++;
                // 两个区间有重叠
            } else {
                result.remove(count);
                Interval newInterval = new Interval(origin.start, o1.end < origin.end ? origin.end : o1.end);
                result.add(newInterval);
            }
        }

        return result;
    }
}
