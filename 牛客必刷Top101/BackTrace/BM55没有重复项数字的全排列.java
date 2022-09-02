package BackTrace;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/7/30 10:57
 * @File: BM55没有重复项数字的全排列.java
 * @Software: IntelliJ IDEA
 */
public class BM55没有重复项数字的全排列 {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(num);  // 先排序
        backTrace(num, temp);
        return result;
    }

    public void backTrace(int[] num, ArrayList<Integer> temp) {
        // temp的长度等于数组的长度，说明找到了一种排列
        if (temp.size() == num.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            // 当前位置的数已经添加过
            if (temp.contains(num[i])) {
                continue;
            }
            temp.add(num[i]);
            backTrace(num, temp);
            temp.remove(temp.size() - 1);
        }

    }
}
