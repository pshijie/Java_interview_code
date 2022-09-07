/**
 * @author psj
 * @date 2022/9/6 23:02
 * @File: 二叉搜索子树的最大键值和.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1373
// 给你一棵以root为根的二叉树，请你返回任意二叉搜索子树的最大键值和
public class 二叉搜索子树的最大键值和 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private final int INF = 100000000;
    private int ans = 0;

    // 求以root为根节点的树的总和、左子树最大值、右子树最小值
    private int[] dfs(TreeNode root) {
        // 以root为根节点
        // 第一位为左子树的总和，第二位为左子树的最小值，第三位为左子树的最大值
        int[] left = {0, root.val, -INF};  // 即使左子树为空，也可以进行下面二叉搜索树的判断(也可以是二叉搜索树)
        // 第一位为右子树的总和，第二位为右子树的最小值，第三位为右子树的最大值
        int[] right = {0, INF, root.val};  // 即使右子树为空，也可以进行下面二叉搜索树的判断(也可以是二叉搜索树)

        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }

        if (left[2] < root.val && root.val < right[1]) {
            int sum = left[0] + right[0] + root.val;
            ans = Math.max(ans, sum);
            return new int[]{sum, left[1], right[2]};  // 左子树的最小值就为以root为根的树的最小值，右子树的最大值就是以root为根的树的最大值
        }
        // 不是二叉搜索树时
        return new int[]{-INF, -INF, INF};
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
}
