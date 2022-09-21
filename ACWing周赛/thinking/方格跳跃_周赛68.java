package thinking;

import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/21 10:51
 * @File: 方格跳跃_周赛68.java
 * @Software: IntelliJ IDEA
 */
public class 方格跳跃_周赛68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        int result = 0;

        // <<< | >...< | >>>，找到左侧所有的<和右侧所有的>的数量即为结果数
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                result++;
            } else {
                break;
            }
        }
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '>') {
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
