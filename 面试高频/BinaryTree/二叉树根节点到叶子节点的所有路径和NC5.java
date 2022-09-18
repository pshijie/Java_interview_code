package BinaryTree;

/**
 * @author psj
 * @date 2022/9/18 9:07
 * @File: 二叉树根节点到叶子节点的所有路径和NC5.java
 * @Software: IntelliJ IDEA
 */
public class 二叉树根节点到叶子节点的所有路径和NC5 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return root.val;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }

        int total = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return total;
        } else {
            return dfs(root.left, total) + dfs(root.right, total);
        }
    }
}
