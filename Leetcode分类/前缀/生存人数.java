package 前缀;

/**
 * @author psj
 * @date 2022/10/4 9:43
 * @File: 生存人数.java
 * @Software: IntelliJ IDEA
 */
// 面试题16.10
// https://leetcode.cn/problems/living-people-lcci/

public class 生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        // 保存每年新增人数
        int[] r = new int[102];
        for (int i = 0; i < birth.length; i++) {
            // 该年的出生人数
            r[birth[i] - 1900]++;
            // 该年的死亡人数(因为某年死亡的人数也计入生存人数，所以death[i]+1才是实际死亡年份)
            r[death[i] - 1900 + 1]--;
        }
        // 从1900年起，遍历过程中每年存活的人数
        int l = 0;
        // 从1900年起，遍历过程中每年存活的人数的最大值
        int p = 0;
        // 存活人数最多的年份
        int y = 0;
        for (int i = 0; i < 101; i++) {
            l += r[i];  // 计算前缀和
            if (l > p) {
                p = l;
                y = i + 1900;
            }
        }
        return y;
    }
}
