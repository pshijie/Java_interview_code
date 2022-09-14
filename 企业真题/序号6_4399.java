import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/14 17:08
 * @File: 序号6_4399.java
 * @Software: IntelliJ IDEA
 */
public class 序号6_4399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(oneOrtwo(n) + " " + oneOrtwoOrthree(n) + " " + twoOrthree(n));
    }

    private static int twoOrthree(int n) {
        if (n <= 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    private static int oneOrtwoOrthree(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    private static int oneOrtwo(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
