package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/7/21 9:30
 * @File: BM35判断是不是完全二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM35判断是不是完全二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean notComplete = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            // 如果当前节点为空
            if (curNode == null) {
                notComplete = true;
                continue;
            }
            // 如果已经执行了上述代码块，就不能执行到该步了
            // 因为上述代码块已经说明当前层的左侧出现空节点,当前层后续节点必须为空节点
            // 如果执行到该步且notComplete=true(说明上面代码块执行),说明后续节点不为空节点
            if (notComplete) {
                return false;
            }
            queue.offer(curNode.left);
            queue.offer(curNode.right);
        }
        return true;
    }
}
