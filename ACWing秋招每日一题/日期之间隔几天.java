/**
 * @author psj
 * @date 2022/9/20 23:15
 * @File: 日期之间隔几天.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1360
public class 日期之间隔几天 {
    private final int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return 1;
        }
        return 0;
    }

    private int getDays(int year, int month) {
        if (month != 2) {
            return months[month];
        }
        return isLeap(year) + 28;
    }

    private int get(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int res = 0;
        for (int i = 1971; i < year; i++) {
            res += 365 + isLeap(i);
        }
        for (int i = 1; i < month; i++) {
            res += getDays(year, i);
        }
        return res + day;
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(get(date1) - get(date2));
    }
}
