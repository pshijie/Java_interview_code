package BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/2 9:28
 * @File: 二叉搜索树的第k个节点NC81.java
 * @Software: IntelliJ IDEA
 */
public class 二叉搜索树的第k个节点NC81 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list = new LinkedList<>();

    public int KthNode(TreeNode proot, int k) {
        if (proot == null) {
            return -1;
        }
        dfs(proot);
        if (list.size() < k) {
            return -1;
        }
        return list.get(k-1);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
