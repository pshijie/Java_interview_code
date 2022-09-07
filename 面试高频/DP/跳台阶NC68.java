package DP;

/**
 * @author psj
 * @date 2022/9/7 10:19
 * @File: 跳台阶NV68.java
 * @Software: IntelliJ IDEA
 */
public class 跳台阶NC68 {
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
