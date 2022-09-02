package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/7/26 10:52
 * @File: BM50两数之和.java
 * @Software: IntelliJ IDEA
 */
public class BM50两数之和 {
    public int[] twoSum (int[] numbers, int target) {
        // 构建numbers[i]和i的映射关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            // target - numbers[i]的下标肯定要小于i
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            }else{
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
