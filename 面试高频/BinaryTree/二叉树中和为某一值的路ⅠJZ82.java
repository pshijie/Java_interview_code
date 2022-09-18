package BinaryTree;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/9/18 9:22
 * @File: 二叉树中和为某一值的路径ⅡNC8.java
 * @Software: IntelliJ IDEA
 */
// 判断从节点出发是否有路径
public class 二叉树中和为某一值的路ⅠJZ82 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int curSum, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (root.val + curSum == sum) {
                return true;
            } else {
                return false;
            }
        }

        curSum += root.val;

        return dfs(root.left, curSum, sum) || dfs(root.right, curSum, sum);
    }
}
