package BinaryTree;

import java.util.*;

/**
 * @author psj
 * @date 2022/9/9 10:09
 * @File: 按之字形顺序打印二叉树NC14.java
 * @Software: IntelliJ IDEA
 */

public class 按之字形顺序打印二叉树NC14 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (flag) {
                    temp.add(0, curNode.val);
                } else {
                    temp.add(curNode.val);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
            }
            flag = !flag;
            result.add(temp);
        }
        return result;
    }
}
