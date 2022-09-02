package BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/17 9:15
 * @File: BM25二叉树的后序遍历.java
 * @Software: IntelliJ IDEA
 */
public class BM25二叉树的后序遍历 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list;

    public int[] postorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        postOrder(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}
