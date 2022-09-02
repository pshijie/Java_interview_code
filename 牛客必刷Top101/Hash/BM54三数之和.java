package Hash;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/7/26 12:02
 * @File: BM54三数之和.java
 * @Software: IntelliJ IDEA
 */
public class BM54三数之和 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = num.length;
        if (len < 3) {
            return result;
        }
        Arrays.sort(num);

        for (int i = 0; i < len; i++) {
            // cur是固定的,移动left和right即可
            int cur = num[i];
            // 如果cur大于0，则left和right肯定大于0,不需要继续遍历
            if (cur > 0) {
                return result;
            }
            // 有多个重复的cur时，只要找到最后一个cur开始下面操作即可
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int temp = cur + num[left] + num[right];
                if (temp == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(num[left]);
                    list.add(num[right]);
                    result.add(list);
                    // 判断是left指针指向是否重复(重复的话list也是一样的,不需要重复添加)
                    while (left < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    // 判断是right指针指向是否重复(重复的话list也是一样的,不需要重复添加)
                    while (left < right && num[right] == num[right - 1]) {
                        right--;
                    }
                    // 移动指针
                    left++;
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;
    }
}
