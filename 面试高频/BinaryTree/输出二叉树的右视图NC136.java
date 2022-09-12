package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/12 10:27
 * @File: 输出二叉树的右视图NC136.java
 * @Software: IntelliJ IDEA
 */
public class 输出二叉树的右视图NC136 {
    public int[] solve(int[] xianxu, int[] zhongxu) {
        TreeNode root = buildTree(xianxu, 0, xianxu.length - 1, zhongxu, 0, zhongxu.length - 1);
        ArrayList<Integer> list = rightSideView(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private ArrayList<Integer> rightSideView(TreeNode root) {
        // 记录每一层最右边节点的深度
        HashMap<Integer, Integer> map = new HashMap<>();
        // 记录最大深度
        int max_depth = -1;
        // 节点栈
        Stack<TreeNode> nodes = new Stack<>();
        // 每个节点对应的深度栈
        Stack<Integer> depths = new Stack<>();

        nodes.push(root);
        depths.push(0);
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pop();
            int curDepth = depths.pop();
            // 需要判空，因为加进来的有可能是叶子节点的孩子节点
            if (curNode != null) {
                max_depth = Math.max(max_depth, curDepth);
                // 如果当前高度不存在，则将当前节点对应的高度加入
                // 当前节点一定是每一层的最右侧节点，因为栈在push的时候将右节点后入栈
                if (map.get(curDepth) == null) {
                    map.put(curDepth, curNode.val);
                }
                nodes.push(curNode.left);
                nodes.push(curNode.right);
                depths.push(curDepth + 1);
                depths.push(curDepth + 1);
            }
        }

        // 记录最大深度是为了方便遍历map
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    private TreeNode buildTree(int[] xianxu, int xStart, int xEnd, int[] zhongxu, int zStart, int zEnd) {
        if (xStart > xEnd || zStart > zEnd) {
            return null;
        }
        int rootVal = xianxu[xStart];
        int index = 0;
        for (int i = zStart; i < zhongxu.length; i++) {
            if (rootVal == zhongxu[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int len = index - zStart;
        root.left = buildTree(xianxu, xStart + 1, xStart + len, zhongxu, zStart, index - 1);
        root.right = buildTree(xianxu, xStart + len + 1, xEnd, zhongxu, index + 1, zEnd);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
