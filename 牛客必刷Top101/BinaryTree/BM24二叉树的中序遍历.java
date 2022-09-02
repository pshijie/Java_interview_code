package BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/17 9:14
 * @File: BM24二叉树的中序遍历.java
 * @Software: IntelliJ IDEA
 */
public class BM24二叉树的中序遍历 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list;

    public int[] inorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        inOrder(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
