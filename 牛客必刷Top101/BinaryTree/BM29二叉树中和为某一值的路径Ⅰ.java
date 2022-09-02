package BinaryTree;

/**
 * @author psj
 * @date 2022/7/17 9:50
 * @File: BM29二叉树中和为某一值的路径Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM29二叉树中和为某一值的路径Ⅰ {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
