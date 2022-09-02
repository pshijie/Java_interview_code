package BinaryTree;

import java.util.*;

/**
 * @author psj
 * @date 2022/7/21 10:16
 * @File: BM38在二叉树中找到两个节点的最近公共祖先.java
 * @Software: IntelliJ IDEA
 */
public class BM38在二叉树中找到两个节点的最近公共祖先 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // 方法1:dfs
//         return helper(root, o1, o2).val;

        // 方法2:bfs
        Map<Integer, Integer> parent = new HashMap<>();  // 记录每个节点的父节点和当前节点的映射
        parent.put(root.val, Integer.MAX_VALUE);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 直到找到o1和o2便可停止while循环,不需要遍历整棵树*
        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                parent.put(curNode.left.val, curNode.val);
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                parent.put(curNode.right.val, curNode.val);
                queue.add(curNode.right);
            }
        }
        Set<Integer> ancestors = new HashSet<>(); // 用于记录o1的所有祖先节点(包括自己)
        while (parent.containsKey(o1)) {
            ancestors.add(o1);
            o1 = parent.get(o1);
        }
        // 查看ancestors中是否包含o2或o2的祖先
        // 包含则包含的o2或o2的祖先就是最近公共子节点
        while (!ancestors.contains(o2)) {
            o2 = parent.get(o2);
        }
        return o2;
    }

    public TreeNode helper(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        // 递归遍历左子树，只要在左子树中找到了o1或o2，则先找到谁就返回谁
        // 不需要判断另一个节点是否在左子树中
        TreeNode left = helper(root.left, o1, o2);
        // 递归遍历右子树，只要在右子树中找到了o1或o2，则先找到谁就返回谁
        TreeNode right = helper(root.right, o1, o2);
        // 如果在左子树中o1和o2都找不到，则o1和o2一定都在右子树中
        // 右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        if (left == null) {
            return right;
            // 与上同理
        } else if (right == null) {
            return left;
            // 当left和right均不为空时，说明o1、o2节点分别在root两侧, 最近公共祖先即为root
        } else {
            return root;
        }
    }
}
