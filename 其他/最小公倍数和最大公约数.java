import java.util.Scanner;

/**
 * @author psj
 * @date 2022/10/11 17:36
 * @File: 最小公倍数和最大公约数.java
 * @Software: IntelliJ IDEA
 */
public class 最小公倍数和最大公约数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(lcm(a, b));
            System.out.println(gcd(a, b));
        }
    }

    // 求最大公约数
    public static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        a = max;
        b = min;
        // 辗转相除法
        // 比如a=27和b=18，c=9；第二轮就是a=18,b=9，c=0，退出
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    // 求最大公约数：递归
    public static int gcd_recursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd_recursive(b, a % b);
    }

    // 求最小公倍数:两数之积除以最大公约数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
