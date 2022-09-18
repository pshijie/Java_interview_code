package BinaryTree;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/9/18 9:22
 * @File: 二叉树中和为某一值的路径ⅡNC8.java
 * @Software: IntelliJ IDEA
 */
// 列出所有从节点出发的路径
public class 二叉树中和为某一值的路径ⅡNC8 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> result;
    ArrayList<Integer> list;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, expectNumber);
        return result;
    }

    private void dfs(TreeNode root, int expectNumber) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        expectNumber -= root.val;

        if (root.left == null && root.right == null && expectNumber == 0) {
            result.add(new ArrayList<>(list));
        }

        dfs(root.left, expectNumber);
        dfs(root.right, expectNumber);
        list.remove(list.size() - 1);
    }
}
