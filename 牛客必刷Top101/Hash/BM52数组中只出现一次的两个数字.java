package Hash;

/**
 * @author psj
 * @date 2022/7/26 11:18
 * @File: BM52数组中只出现一次的两个数字.java
 * @Software: IntelliJ IDEA
 */
public class BM52数组中只出现一次的两个数字 {
    public int[] FindNumsAppearOnce(int[] array) {
        // 方法1:HashMap
//         Map<Integer, Integer> map = new HashMap<>();
//         List<Integer> result = new ArrayList<>();
//         for (int num : array) {
//             if (map.containsKey(num)) {
//                 map.put(num, map.get(num) + 1);
//             } else {
//                 map.put(num, 1);
//             }
//         }
//         for(int key:map.keySet()){
//             if(map.get(key) == 1){
//                 result.add(key);
//             }
//         }
//         if(result.get(0) > result.get(1)){
//             return new int[]{result.get(1), result.get(0)};
//         }else{
//             return new int[]{result.get(0), result.get(1)};
//         }

        // 方法2:异或
        // 记录整个数组的异或结果
        int z = 0;
        for (int num : array) {
            z ^= num;
        }
        // 找到z的最低位的1所在位置
        int m = 1;
        while ((z & m) == 0) {
            m <<= 1;
        }
        int result1 = 0, result2 = 0;
        for (int num : array) {
            if ((num & m) == 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }
        if (result1 < result2) {
            return new int[]{result1, result2};
        } else {
            return new int[]{result2, result1};
        }

    }
}