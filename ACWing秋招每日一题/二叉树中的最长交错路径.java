/**
 * @author psj
 * @date 2022/9/21 23:32
 * @File: 二叉树中的最长交错路径.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1372
public class 二叉树中的最长交错路径 {
    int result = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, -1);
        return result;
    }

    // dir=0表示往左走；dir=1表示往右走
    // 该函数表示往左或往右，从中取最长路径数
    private int dfs(TreeNode root, int dir) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, 0);
        int right = dfs(root.right, 1);
        // 是求每个节点形成的交替路径的最大值，所以每个节点都要进行比较
        result = Math.max(result, Math.max(left, right));
        // 如果当前是父节点向左走到的，则下一步需要往右走
        if (dir == 0) {
            return right + 1;
        } else {
            return left + 1;
        }
    }
}
