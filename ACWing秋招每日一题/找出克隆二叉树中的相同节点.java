import com.sun.source.tree.Tree;

/**
 * @author psj
 * @date 2022/9/24 22:39
 * @File: 找出克隆二叉树中的相同节点.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1379
public class 找出克隆二叉树中的相同节点 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (left != null) {
            return left;
        }
        return right;
    }
}
