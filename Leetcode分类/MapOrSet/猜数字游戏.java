package MapOrSet;

/**
 * @author psj
 * @date 2022/10/14 10:26
 * @File: 猜数字游戏.java
 * @Software: IntelliJ IDEA
 */
// Leetcode299
// https://leetcode.cn/problems/bulls-and-cows/

public class 猜数字游戏 {
    // 统计两个字符串中数字和位置都对应相等的个数以及数字相等但位置不一样的个数
    public String getHint(String secret, String guess) {
        int A = 0;
        int[] mapS = new int[10];
        int[] mapG = new int[10];
        for (int i = 0; i < guess.length(); i++) {
            // 统计两个字符串中数字和位置都对应相等的个数
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                // 分别记录secret和guess中每个数字的个数，然后取两者较小的就是相等数字的个数
                // 比如secret中有3个2，guess中有4个2，两者相等的数字就至少有3个
                mapS[secret.charAt(i) - '0']++;
                mapG[guess.charAt(i) - '0']++;
            }
        }
        int B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(mapS[i], mapG[i]);
        }
        return A + "A" + B + "B";
    }
}
