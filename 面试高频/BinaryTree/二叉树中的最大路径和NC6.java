package BinaryTree;

/**
 * @author psj
 * @date 2022/9/25 9:54
 * @File: 二叉树中的最大路径和NC6.java
 * @Software: IntelliJ IDEA
 */
public class 二叉树中的最大路径和NC6 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 因为节点值可能为负数,所以要和0做比较
        // 计算左孩子的贡献
        int leftMax = Math.max(dfs(root.left), 0);
        // 计算右孩子的贡献
        int rightMax = Math.max(dfs(root.right), 0);

        result = Math.max(result, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);

    }
}
