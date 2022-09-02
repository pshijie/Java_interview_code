package BinaryTree;

import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/20 9:32
 * @File: BM33二叉树的镜像.java
 * @Software: IntelliJ IDEA
 */
public class BM33二叉树的镜像 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Mirror(TreeNode pRoot) {
        // 方法1:dfs
        if (pRoot == null) {
            return null;
        }
        TreeNode newRight = Mirror(pRoot.left);
        TreeNode newLeft = Mirror(pRoot.right);
        pRoot.left = newLeft;
        pRoot.right = newRight;
        return pRoot;
        // 方法2:bfs
//        if (pRoot == null) {
//            return null;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(pRoot);
//        while (!stack.isEmpty()) {
//            TreeNode curNode = stack.pop();
//            if (curNode.left != null) {
//                stack.push(curNode.left);
//            }
//            if (curNode.right != null) {
//                stack.push(curNode.right);
//            }
//            // 交换左右节点时，stack中的节点也会改变
//            TreeNode temp = curNode.left;
//            curNode.left = curNode.right;
//            curNode.right = temp;
//        }
//        return pRoot;
    }

}
