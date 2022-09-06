import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/6 11:44
 * @File: 统计子矩阵.java
 * @Software: IntelliJ IDEA
 */
// 第十三届蓝桥杯省赛C++B组
// 给定一个 N×M 的矩阵 A，请你统计有多少个子矩阵 (最小 1×1，最大 N×M) 满足子矩阵中所有数的和不超过给定的整数 K?
public class 统计子矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = sc.nextInt() + s[i - 1][j];
            }
        }

        long result = 0;
        // i和j分别为上下边界
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int l = 1, r = 1, sum = 0; r <= m; r++) {
                    // 计算出第i行到第j行之间且第l列到第r列形成的子矩阵总和
                    sum += s[j][r] - s[i - 1][r];
                    // 此时如果该子矩阵的和大于k，就移动l(因为数组全是非负数，移动l后子矩阵一定会减少)
                    while (sum > k) {
                        // 移动后属于第i行到第j行之间且第l列的元素都要删除
                        sum -= s[j][l] - s[i - 1][l];
                        l++;
                    }
                    result += r - l + 1;
                }
            }
        }
        System.out.println(result);
    }
}
