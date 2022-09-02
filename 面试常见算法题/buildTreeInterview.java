/**
 * @author psj
 * @date 2022/8/20 16:43
 * @File: buildTree.java
 * @Software: IntelliJ IDEA
 */
// 剑指offer7
// 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
public class buildTreeInterview {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        int index = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftLen = index - iStart;
        root.left = buildTree(preorder, pStart + 1, pStart + leftLen, inorder, iStart, index - 1);
        root.right = buildTree(preorder, pStart + leftLen + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }
}
