import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/14 11:22
 * @File: 序号4_4399.java
 * @Software: IntelliJ IDEA
 */
public class 序号4_4399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int remind = n;
        int curNum = 0;
        for (int i = 0; ; i++) {
            if (arr[i % n] != 0) {
                curNum++;
            } else {
                continue;
            }

            if (curNum == 3) {
                arr[i % n] = 0;
                remind--;
                curNum = 0;
            }

            if (remind == 1) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
