import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author psj
 * @date 2022/9/16 22:24
 * @File: 检查整数及其两倍数是否存在.java
 * @Software: IntelliJ IDEA
 */
// LeetCode 1346
public class 检查整数及其两倍数是否存在 {
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // 判断set中是否包含当前元素的二倍元素或者1/2倍元素(需要先判断当前元素为偶数)
            if ((set.contains(arr[i] * 2) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2)))) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }
}
