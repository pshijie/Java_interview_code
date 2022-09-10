package BinaryTree;

/**
 * @author psj
 * @date 2022/9/10 9:56
 * @File: 重建二叉树NC12.java
 * @Software: IntelliJ IDEA
 */
public class 重建二叉树NC12 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int pStart, int pEnd, int[] vin, int vStart, int vEnd) {
        if (pStart > pEnd || vStart > vEnd) {
            return null;
        }

        int val = pre[pStart];
        int index = 0;
        for (int i = vStart; i < vin.length; i++) {
            if (vin[i] == val) {
                index = i;
                break;
            }
        }

        int leftLen = index - vStart;
        TreeNode root = new TreeNode(val);
        root.left = reConstructBinaryTree(pre, pStart+1, pStart + leftLen, vin, vStart, index-1);
        root.right = reConstructBinaryTree(pre, pStart+leftLen+1, pEnd, vin, index+1, vEnd);
        return root;
    }

}
