package DFSor回溯;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/6 10:52
 * @File: 组合.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 77
// https://leetcode.cn/problems/combinations/

public class 组合 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        // 不需要排序是因为默认使用的数组就是1,2,3...
        ArrayList<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path);
        return result;
    }

    private void dfs(int n, int k, int index, ArrayList<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // i的上界满足:n-i+1=k-path.size()
        // n-i+1表示区间[i,n]的长度
        // k-path.size()表示剩下要找的数的个数
        // 比如[1,2,3,4,5]中取三个数，取到3，4，5后，就不能以4开头，因为4,5后面没有数字作为第三个数了
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
