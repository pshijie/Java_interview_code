import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/8/19 11:17
 * @File: combinationSum3Interview.java
 * @Software: IntelliJ IDEA
 */
// LeetCode 216
// 找出所有相加之和为n的k个数的组合，且满足下列条件：
//  1.只使用数字1到9
//  2.每个数字最多使用一次
public class combinationSum3Interview {
    List<List<Integer>> result;
    int k;
    int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        this.n = n;
        this.k = k;
        dfs(0, new ArrayList<>(), 0, 1);
        return result;
    }

    public void dfs(int len, List<Integer> temp, int current, int index) {
        if (len == k) {
            if (current == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        // i表示当前准备加入列表的数字
        for (int i = index; i < 10; i++) {
            temp.add(i);
            dfs(len + 1, temp, current + i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
