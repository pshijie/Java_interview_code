package BinaryTree;

/**
 * @author psj
 * @date 2022/9/16 9:57
 * @File: 判断是不是平衡二叉树NC62.java
 * @Software: IntelliJ IDEA
 */
public class 判断是不是平衡二叉树NC62 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

}
