import java.util.HashMap;

/**
 * @author psj
 * @date 2022/9/12 11:01
 * @File: 字符串操作_腾讯音乐.java
 * @Software: IntelliJ IDEA
 */
// 给定一个只包含小写字母字符串，每次可以选择两个相同的字符删除，并在字符串结尾新增任意一个小写字母。
// 请问最少多少次操作后，所有的字母都不相同？
public class 字符串操作_腾讯音乐 {
    public int minOperations(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 字母和其出现次数的映射
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }

        int result = 0;  // 配对后生成的字母数
        int remind = 0;  // 配完对后该字母剩余的个数(0/1)
        for (char c : map.keySet()) {
            // 当前字符出现的次数
            int num = map.get(c);
            result += (num / 2);  // 每两个配对就会生成一个新字母,比如当前有四个a，会生成两个另外的字母
            // 假设有5个a，配对后还剩1个a
            // 或者只有1个b，不需要配对，所以还剩1个b
            if (num % 2 == 1) {
                remind++;
            }
        }

        // 第一次配对完成后需要判断总字母数(配对的次数+配对后剩余的当个字母)是否大于26
        // 如果大于26说明还有重复的字母(配对后生成的字母和其他字母可能相同，形成了新的对)
        // 此时和26的差值就是第二次配对的次数
        int sumCharacter = remind + result;
        if (sumCharacter > 26) {
            // result为初次完成配对的次数，sumCharacter - 26是第二次需要配对的次数
            return result + sumCharacter - 26;
        } else {
            return result;
        }
    }
}
