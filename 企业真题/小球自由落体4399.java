import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/14 10:55
 * @File: 小球自由落体4399.java
 * @Software: IntelliJ IDEA
 */
public class 小球自由落体4399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double ans1 = 100;
        int index = 0;
        while (index != n - 1) {
            ans1 += 100 / Math.pow(2, index+1) * 2;
            index++;
        }
        double ans2 = 100 / Math.pow(2, n);
        System.out.print(ans1 + " " + ans2);
    }
}
