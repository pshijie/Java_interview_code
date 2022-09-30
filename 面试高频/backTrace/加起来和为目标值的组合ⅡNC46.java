package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author psj
 * @date 2022/9/30 8:59
 * @File: 加起来和为目标值的组合ⅡNC46.java
 * @Software: IntelliJ IDEA
 */
public class 加起来和为目标值的组合ⅡNC46 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        dfs(num, target, 0, new ArrayList<Integer>());
        return result;
    }

    private void dfs(int[] num, int target, int start, ArrayList<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0 && list.size() > 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < num.length; i++) {
            // set.contains(i-1)=false说明已经访问过num[i-1]并且回溯
            if (i > 0 && num[i] == num[i - 1] && !set.contains(i - 1)) {
                continue;
            }
            if (num[i] > target) {
                break;
            }
            list.add(num[i]);
            set.add(i);

            dfs(num, target - num[i], i + 1, list);

            list.remove(list.size() - 1);
            set.remove(i);
        }
    }
}
