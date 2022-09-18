package BinaryTree;

/**
 * @author psj
 * @date 2022/9/18 9:22
 * @File: 二叉树中和为某一值的路径ⅡNC8.java
 * @Software: IntelliJ IDEA
 */
// 有多少条路径(不一定从节点出发)
public class 二叉树中和为某一值的路ⅢJZ84 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    int result;

    public int FindPath(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        // 以root为根的路径数
        dfs(root, sum);
        // 分别以左节点和右节点为根
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return result;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (sum == root.val) {
            result++;
        }

        sum -= root.val;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
