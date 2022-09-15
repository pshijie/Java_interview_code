/**
 * @author psj
 * @date 2022/9/15 22:14
 * @File: 时钟指针的夹角.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1344
public class 时钟指针的夹角 {
    public double angleClock(int hour, int minutes) {
        int onehourAngle = 30;
        int oneminutesAngle = 6;

        double hourAngle = onehourAngle * (hour % 12 + minutes / 60.0);
        double minutesAngle = oneminutesAngle * minutes;

        double diff = Math.abs(hourAngle - minutesAngle);
        return Math.min(diff, 360 - diff);
    }
}
