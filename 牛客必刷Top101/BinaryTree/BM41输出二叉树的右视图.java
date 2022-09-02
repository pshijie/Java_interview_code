package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author psj
 * @date 2022/7/22 10:03
 * @File: BM41输出二叉树的右视图.java
 * @Software: IntelliJ IDEA
 */
public class BM41输出二叉树的右视图 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] solve(int[] xianxu, int[] zhongxu) {
        TreeNode root = buildTree(xianxu, 0, xianxu.length - 1, zhongxu, 0,
                zhongxu.length - 1);
        ArrayList<Integer> temp = rightSideView(root);
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    // 构建二叉树
    public TreeNode buildTree(int[] pre, int pStart, int pEnd, int[] inOrder,
                              int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = pre[pStart];
        int index = 0;
        for (int i = iStart; i < inOrder.length; i++) {
            if (inOrder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - iStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, pStart + 1, pStart + leftSize, inOrder, iStart,
                index - 1);
        root.right = buildTree(pre, pStart + leftSize + 1, pEnd, inOrder, index + 1,
                iEnd);
        return root;
    }

    //
    public ArrayList<Integer> rightSideView(TreeNode root) {
        // 保持当前层的深度和该层最右侧节点的映射
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        // 记录最大深度
        int max_depth = -1;
        Stack<TreeNode> nodes = new Stack<TreeNode>();  // 注意是Stack不是Queue
        // 每个节点对应的深度
        Stack<Integer> depths = new Stack<Integer>();
        nodes.push(root);
        depths.push(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int depth = depths.pop();
            if (node != null) {
                max_depth = Math.max(max_depth, depth);  // 维护最大深度
                // 该层第一个访问的元素就是当前层的最右侧元素(因为使用的是stack不是Queue)
                if (mp.get(depth) == null)
                    mp.put(depth, node.val);
                nodes.push(node.left);
                nodes.push(node.right);
                depths.push(depth + 1);
                depths.push(depth + 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i <= max_depth; i++)
            res.add(mp.get(i));
        return res;
    }
}
