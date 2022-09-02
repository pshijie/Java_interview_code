package BackTrace;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author psj
 * @date 2022/7/30 11:26
 * @File: BM56有重复项数字的全排列.java
 * @Software: IntelliJ IDEA
 */
public class BM56有重复项数字的全排列 {
    Boolean[] visited;  // 用于标记num中的元素是否被访问过
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        visited = new Boolean[num.length];
        Arrays.fill(visited, false);
        result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backTrace(num, temp);
        return result;
    }

    public void backTrace(int[] num, ArrayList<Integer> temp) {
        if (temp.size() == num.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            // 该元素已经被加入就不需要再被加入
            if (visited[i]) {
                continue;
            }
            // 当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
            // 如果在同一棵子树上即使num[i-1]和num[i]相同也无所谓
            if (i > 0 && num[i - 1] == num[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.add(num[i]);

            backTrace(num, temp);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
