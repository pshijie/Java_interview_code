package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/7/26 11:04
 * @File: BM51数组中出现次数超过一半的数字.java
 * @Software: IntelliJ IDEA
 */
public class BM51数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        // 方法1:HashMap
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < array.length; i++) {
//             if (map.containsKey(array[i])) {
//                 map.put(array[i], map.get(array[i]) + 1);
//             }else{
//                 map.put(array[i], 1);
//             }
//         }
//         for (int key : map.keySet()) {
//             if (map.get(key) > array.length / 2) {
//                 return key;
//             }
//         }

//         return -1;

        // 方法2:摩尔投票
        int x = 0;
        int count = 0;
        for (int num : array) {
            // 当count=0时才去修改x的值,后续的数都是和x比较
            // 剩余数组中众数是不变的
            if (count == 0) {
                x = num;
            }

            if (num == x) {
                count++;
            } else {
                count--;
            }
        }
        return x;
    }
}
