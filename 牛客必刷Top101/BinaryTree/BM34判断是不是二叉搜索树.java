package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/20 9:44
 * @File: BM34判断是不是二叉搜索树.java
 * @Software: IntelliJ IDEA
 */
public class BM34判断是不是二叉搜索树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // 方法1:dfs
//         return BST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // 方法2:bfs
        Stack<TreeNode> s = new Stack<>();
        TreeNode curNode = root;
        // 记录中序遍历的数组
        List<Integer> sort = new ArrayList<>();
        // 采用bfs进行中序遍历
        while (curNode != null || !s.isEmpty()) {
            // 往左边一直走
            while (curNode != null) {
                s.push(curNode);
                curNode = curNode.left;
            }
            curNode = s.pop();
            sort.add(curNode.val);
            curNode = curNode.right;
        }

        for (int i = 1; i < sort.size(); i++) {
            if (sort.get(i - 1) > sort.get(i)) {
                return false;
            }
        }
        return true;
    }

    // left为左子树的最大值,right为右子树的最小值
    public boolean BST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        // 如果当前节点的值小于等于左子树节点最大值或者大于等于右子树节点最小值，则不合法
        if (root.val <= left || root.val >= right) {
            return false;
        }
        // 往左子树递归时，left不变，对应右子树由于要考虑当前节点，right变为root.val
        // 往右子树递归时同理
        return BST(root.left, left, root.val) && BST(root.right, root.val, right);
    }
}
