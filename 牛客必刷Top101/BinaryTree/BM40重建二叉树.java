package BinaryTree;

/**
 * @author psj
 * @date 2022/7/22 9:49
 * @File: BM40重建二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM40重建二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return preInorder(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    public TreeNode preInorder(int[] pre, int pStart, int pEnd, int[] vin,
                               int vStart, int vEnd) {
        if (pStart > pEnd || vStart > vEnd) {
            return null;
        }
        int rootVal = pre[pStart];
        int index = 0;
        for (int i = vStart; i < vin.length; i++) {
            if (vin[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - vStart;
        root.left = preInorder(pre, pStart + 1, pStart + leftSize, vin, vStart,
                index - 1);
        root.right = preInorder(pre, pStart + leftSize + 1, pEnd, vin, index + 1, vEnd);
        return root;
    }
}
