package simulation;

import org.junit.Before;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/21 10:27
 * @File: 去掉0_周赛68.java
 * @Software: IntelliJ IDEA
 */
public class 去掉0_周赛68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String input = sc.next();
            int left = 0;  // 记录最左边的1所在的位置
            int right = input.length()-1;  // 记录最右边的1所在的位置

            // 左右两边遇到1就停止
            while (left < input.length()) {
                if (input.charAt(left) == '0') {
                    left++;
                } else {
                    break;
                }
            }
            while (right >= 0) {
                if (input.charAt(right) == '0') {
                    right--;
                } else {
                    break;
                }
            }

            int result = 0;
            for (int j = left; j < right; j++) {
                if (input.charAt(j) == '0') {
                    result++;
                }
            }
            System.out.println(result);

        }

    }
}
