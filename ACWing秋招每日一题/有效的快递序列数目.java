/**
 * @author psj
 * @date 2022/9/16 23:47
 * @File: 有效的快递序列数目.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1359
public class 有效的快递序列数目 {
    public int countOrders(int n) {
        long result = 1;
        long mod = (long) 1e9 + 7;
        // 对于第n对快递，可以插入的情况为(2n-1)+(2n-2)+...+1=2*n^2-n
        // 所以对于所有n对为f(n)=f(n-1)*(2*n^2-n)
        for (int i = 2; i <= n; i++) {
            result *= (2 * i * i - i);
            result %= mod;
        }
        return (int) result;
    }
}
