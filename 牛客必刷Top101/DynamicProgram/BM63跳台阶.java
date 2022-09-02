package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/2 11:58
 * @File: BM63跳台阶.java
 * @Software: IntelliJ IDEA
 */
public class BM63跳台阶 {
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
