package BinaryTree;

/**
 * @author psj
 * @date 2022/7/17 9:48
 * @File: BM28二叉树的最大深度.java
 * @Software: IntelliJ IDEA
 */
public class BM28二叉树的最大深度 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
