package BinaryTree;

/**
 * @author psj
 * @date 2022/9/25 10:10
 * @File: 对称的二叉树NC16.java
 * @Software: IntelliJ IDEA
 */
public class 对称的二叉树NC16 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return dfs(pRoot, pRoot);
    }

    // 比较以root1和root2为根的树是否为对称的树
    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        // 如果只有一个节点为空或者根节点值不同，则必定不对称
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // 比较两个树的子节点对应位置是否满足对称树的条件
        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }
}
