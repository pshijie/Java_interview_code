package slideWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author psj
 * @date 2022/9/7 10:57
 * @File: 最长无重复子数组NC41.java
 * @Software: IntelliJ IDEA
 */
public class 最长无重复子数组NC41 {
    public static int maxLength(int[] arr) {
        // 统计各字符最后一次出现的索引位置
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        // 记录当前不重复子字符串的长度
        int temp = 0;
        // 左右指针
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            int c = arr[right];
            if (!map.containsKey(c)) {
                map.put(c, right);
                temp++;
            } else {
                // 比如abeacfh,此时right指向第二个a,则abe为当前最长不重复子字符串
                // 即移动左指针
                left = Math.max(left, map.get(c));
                temp = right - left;
                // 将该字符此时的位置记录下来
                map.put(c, right);
            }
            result = Math.max(temp, result);
            // 移动右指针
            right++;
        }
        return result;
    }
}
