import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/16 11:26
 * @File: 涂颜料VC3.java
 * @Software: IntelliJ IDEA
 */
public class 涂颜料VC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] numPic = new int[n + 2];
//        for (int i = 0; i < q; i++) {
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            for (int j = l - 1; j < r; j++) {
//                numPic[j]++;
//            }
//        }
//
//        StringBuffer sb = new StringBuffer();
//        for (int num : numPic) {
//            if (num == 0) {
//                sb.append("O");
//                continue;
//            }
//            if ((num) % 3 == 1) {
//                sb.append("R");
//            } else if ((num) % 3 == 2) {
//                sb.append("G");
//            } else {
//                sb.append("B");
//            }
//        }
//        System.out.println(sb.toString());

        // 差分
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            numPic[l]++;
            numPic[r + 1]--;
        }

        // 计算前缀和
        for (int i = 1; i <= n; i++) {
            numPic[i] += numPic[i - 1];
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            int num = numPic[i];
            if (num == 0) {
                sb.append("O");
                continue;
            }
            if ((num) % 3 == 1) {
                sb.append("R");
            } else if ((num) % 3 == 2) {
                sb.append("G");
            } else {
                sb.append("B");
            }
        }
        System.out.println(sb.toString());

    }
}