package backTrace;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/9/26 11:06
 * @File: 有重复项数字的全排列NC42.java
 * @Software: IntelliJ IDEA
 */
public class 有重复项数字的全排列NC42 {
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return result;
        }
        result = new ArrayList<>();
        Arrays.sort(num);
        Boolean[] visited = new Boolean[num.length];
        Arrays.fill(visited, false);
        ArrayList<Integer> temp = new ArrayList<>();
        backTrace(num, temp, visited);
        return result;
    }

    private void backTrace(int[] num, ArrayList<Integer> temp, Boolean[] visited) {
        if (temp.size() == num.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // 变量所有元素
        for (int i = 0; i < num.length; i++) {
            // 该元素已经加入就不再加入
            if (visited[i]) {
                continue;
            }
            // 当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
            // 已经使用过说明进行了回溯，所有visited[i - 1]=false
            if (i > 0 && num[i - 1] == num[i] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            temp.add(num[i]);

            backTrace(num, temp, visited);

            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
