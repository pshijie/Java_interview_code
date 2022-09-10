import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/10 10:37
 * @File: 扭蛋机BL1.java
 * @Software: IntelliJ IDEA
 */
public class 扭蛋机BL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        // 反推
        while (n > 0) {
            // 表示n这个数由2号机得到
            if (n % 2 == 1) {
                n = (n - 1) >> 1;
                sb.append('2');
            } else {
                // 表示n这个数由3号机得到
                n = (n - 2) >> 1;
                sb.append('3');
            }
        }
        System.out.println(sb.reverse());
    }
}
