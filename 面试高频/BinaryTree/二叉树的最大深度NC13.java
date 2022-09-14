package BinaryTree;

/**
 * @author psj
 * @date 2022/9/13 11:01
 * @File: 二叉树的最大深度NC13.java
 * @Software: IntelliJ IDEA
 */
public class 二叉树的最大深度NC13 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
