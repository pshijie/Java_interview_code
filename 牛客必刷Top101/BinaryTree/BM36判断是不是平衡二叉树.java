package BinaryTree;

/**
 * @author psj
 * @date 2022/7/21 9:52
 * @File: BM36判断是不是平衡二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM36判断是不是平衡二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 &&
                IsBalanced_Solution(root.left) &&
                IsBalanced_Solution(root.right);
    }

    public int computeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(computeHeight(node.left), computeHeight(node.right));
    }
}
