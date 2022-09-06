package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/9/6 9:38
 * @File: 实现二叉树先中后序遍历NC45.java
 * @Software: IntelliJ IDEA
 */
public class 实现二叉树先中后序遍历NC45 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders(TreeNode root) {
        if (root == null) {
            return new int[3][];
        }

        ArrayList<Integer> preList = new ArrayList<>();
        ArrayList<Integer> inList = new ArrayList<>();
        ArrayList<Integer> postList = new ArrayList<>();
        int[][] result = new int[3][preList.size()];

        preTraverse(root, preList);
        inTraverse(root, inList);
        postTraverse(root, postList);

        for (int i = 0; i < preList.size(); i++) {
            result[0][i] = preList.get(i);
            result[1][i] = inList.get(i);
            result[2][i] = postList.get(i);
        }
        return result;
    }

    void preTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preTraverse(root.left, list);
        preTraverse(root.right, list);

    }

    void inTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inTraverse(root.left, list);
        list.add(root.val);
        inTraverse(root.right, list);

    }

    void postTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postTraverse(root.left, list);
        postTraverse(root.right, list);
        list.add(root.val);

    }

    public static void main(String[] args) {

    }

}
