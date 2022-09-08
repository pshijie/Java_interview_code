/**
 * @author psj
 * @date 2022/9/8 23:09
 * @File: 在既定时间做作业的学生人数.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1450
public class 在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                result++;
            }
        }
        return result;
    }
}
