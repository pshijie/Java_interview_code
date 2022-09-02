/**
 * @author psj
 * @date 2022/8/21 16:35
 * @File: lowestCommonAncestorInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 236
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
public class lowestCommonAncestorInterview {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left== null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;

    }
}
