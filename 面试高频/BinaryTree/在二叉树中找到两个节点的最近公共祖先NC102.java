package BinaryTree;

/**
 * @author psj
 * @date 2022/9/9 11:12
 * @File: 在二叉树中找到两个节点的最近公共祖先NC.java
 * @Software: IntelliJ IDEA
 */
public class 在二叉树中找到两个节点的最近公共祖先NC102 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        } else {
            return root.val;
        }
    }
}
