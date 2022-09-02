package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/7/22 9:29
 * @File: BM39序列化二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM39序列化二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.append(node.val + ",");
                // 这里因为需要空节点,所以不需要对左右孩子节点判空
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.append("#,");
            }
        }
        // 删除最后一个字符,即","
        result.deleteCharAt(result.length() - 1);
        result.append("]");
        return result.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.equals("[]")) {
            return null;
        }
        // 删除开头的"["和结尾的"]"
        String[] vals = str.substring(1, str.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;  // i表示序列化后的字符串中的下标值(从1开始是因为已经将root加入到树中)
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            // 往字符串下一个位置遍历
            i++;
            if (!vals[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;

        }
        return root;
    }
}
