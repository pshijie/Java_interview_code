package BinaryTree;

/**
 * @author psj
 * @date 2022/7/21 9:59
 * @File: BM37二叉搜索树的最近公共祖先.java
 * @Software: IntelliJ IDEA
 */
public class BM37二叉搜索树的最近公共祖先 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return -1;
        }
        // p和q都在root的右子树中,则两个节点的最近公共祖先肯定是root的右子树中
        if (root.val < p && root.val < q) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // p和q都在root的左子树中,则两个节点的最近公共祖先肯定是root的左子树中
        if (root.val > p && root.val > q) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p和q分别在root的左右两棵子树中,则两个节点的最近公共祖先肯定是root
        return root.val;
    }
}
