package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/7/17 9:27
 * @File: BM27按之字形顺序打印二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM27按之字形顺序打印二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (flag) {
                    temp.add(0, cur.val);
                } else {
                    temp.add(cur.val);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
            }

            flag = !flag;
            result.add(temp);
        }
        return result;
    }
}
