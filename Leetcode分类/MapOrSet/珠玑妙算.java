package MapOrSet;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/10/14 10:37
 * @File: 珠玑妙算.java
 * @Software: IntelliJ IDEA
 */
// 面试题16.15
// https://leetcode.cn/problems/master-mind-lcci/

public class 珠玑妙算 {
    // 和猜数字游戏类似
    public int[] masterMind(String solution, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 记录solution中每个字母出现的次数
        for (char c : solution.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int fake = 0, real = 0;
        // 遍历guess，如果map中出现该字符
        for (char c : guess.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                // 该fake中包含real
                fake++;
                map.put(c, map.get(c) - 1);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                real++;
            }
        }

        int[] result = {real, fake - real};
        return result;
    }
}
