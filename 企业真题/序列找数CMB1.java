import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/9 11:44
 * @File: 序列找数CMB1.java
 * @Software: IntelliJ IDEA
 */
// 从非负整数序列 0, 1, 2, ..., n中给出包含其中n个数的子序列，请找出未出现在该子序列中的那个数
public class 序列找数CMB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        while (sc.hasNext()) {
            sum += sc.nextInt();
        }
        int notFound = (1 + n) * n / 2 - sum;
        System.out.println(notFound);
    }
}
