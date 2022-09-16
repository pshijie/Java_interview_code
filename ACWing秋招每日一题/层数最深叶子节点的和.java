/**
 * @author psj
 * @date 2022/9/8 22:33
 * @File: 层数最深叶子节点的和.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1302
public class 层数最深叶子节点的和 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int depth = -1;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        // 如果发现当前层数比当前最深层还要深
        if (d > depth) {
            depth = d;
            sum = root.val;
            // 如果发现当前层数等于当前最深层，则将总和进行累加
        } else if (d == depth) {
            sum += root.val;
        }
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
}
