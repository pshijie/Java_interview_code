package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.logging.Level;

/**
 * @author psj
 * @date 2022/9/20 10:16
 * @File: 判断一棵二叉树是否为搜索二叉树和完全二叉树NC60.java
 * @Software: IntelliJ IDEA
 */
public class 判断一棵二叉树是否为搜索二叉树和完全二叉树NC60 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public boolean[] judgeIt(TreeNode root) {
        if (root == null) {
            return new boolean[]{true, true};
        }

        boolean isBST = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        boolean isFST = isFST(root);

        return new boolean[]{isBST, isFST};
    }

    // 判断完全二叉树
    private boolean isFST(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 如果遍历到当前节点为空节点，则ended=true
        boolean ended = false;
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            // 当前遍历到的节点为空
            if (head == null) {
                ended = true;
                // 当前遍历到的节点不为空
            } else {
                // 如果之前已经遍历到了空节点，后续节点需要全部为空
                if (ended) {
                    return false;
                }
                queue.offer(head.left);
                queue.offer(head.right);
            }
        }
        return true;
    }

    // 判断二叉搜索树
    private boolean isBST(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isBST(root.left, left, root.val) && isBST(root.right, root.val, right);
    }
}
