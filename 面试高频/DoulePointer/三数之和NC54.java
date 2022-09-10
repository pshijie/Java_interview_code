package DoulePointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/9/10 9:30
 * @File: 三数之和NC54.java
 * @Software: IntelliJ IDEA
 */
public class 三数之和NC54 {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        result = new ArrayList<>();
        int n = num.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(num);

        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && num[i - 1] == num[i]) {
                continue;
            }
            int target = -num[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (num[left] + num[right] == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);
                    // 将重复的排除
                    while (left + 1 < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    while (right - 1 > left && num[right] == num[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (num[left] + num[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;

    }
}
