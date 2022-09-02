package BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/17 9:06
 * @File: BM23二叉树的前序遍历.java
 * @Software: IntelliJ IDEA
 */
public class BM23二叉树的前序遍历 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list;
    public int[] preorderTraversal (TreeNode root) {
        list = new LinkedList<>();
        preOrder(root);
        int[] result = new int[list.size()];
        for(int i= 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;

    }
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
