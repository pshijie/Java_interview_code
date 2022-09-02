package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/2 11:47
 * @File: BM62斐波那契数列.java
 * @Software: IntelliJ IDEA
 */
public class BM62斐波那契数列 {
    // 方法1:备忘录
//     int[] memory;
//     public int Fibonacci(int n) {
//         if(n <= 2){
//             return 1;
//         }
//         memory = new int[n];
//         return slove(n);
//     }
//     public int slove(int n){
//         if(n <= 2){
//             return 1;
//         }

//         if(memory[n-1] != 0){
//             return memory[n-1];
//         }

//         int result = slove(n-1) + slove(n-2);
//         memory[n-1] = result;
//         return result;
//     }

    // 方法2:动态规划
    public int Fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        // dp[i]表示斐波那契数列的第i项的值
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
