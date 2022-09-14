import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/13 11:15
 * @File: 牛牛吃草VC1.java
 * @Software: IntelliJ IDEA
 */
public class 牛牛吃草VC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        int[] wi = new int[n];
        int[] ai = new int[n];

        for (int i = 0; i < n; i++) {
            wi[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextInt();
        }

        // dp[i]表示在i位置停止吃草时的最多吃草数
        int[] dp = new int[n];
        // 从任意位置出发时的dp值
        for (int i = 0; i < n; i++) {
            dp[i] = wi[i];
        }

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                // 判断i和j之间的距离是不是ai[j]的整数倍
                // 是的话说明可以从j跳到i
                // 因为有很多位置可以跳到i，所以选一个最大的dp[j]跳到i
                if ((i - j) % ai[j] == 0) {
                    temp = Math.max(dp[j], temp);
                }
                // wi[i] + temp表示选择从选定的j位置(即当前最大temp值对应的位置)跳到i并且将i位置的草全部吃了
                dp[i] = Math.max(wi[i] + temp, dp[i]);
            }
        }

        // 从dp中选出最大值
        for (int i = 0; i < n; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        System.out.println(result);
    }
}
