/**
 * @author psj
 * @date 2022/9/8 23:16
 * @File: 最大二叉树.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 654
public class 最大二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 构建[l,r]区间的最大二叉树
    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        // 找到[l,r]之间最大的数
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode result = new TreeNode(nums[idx]);
        result.left = build(nums, l, idx - 1);
        result.right = build(nums, idx + 1, r);
        return result;
    }
}
