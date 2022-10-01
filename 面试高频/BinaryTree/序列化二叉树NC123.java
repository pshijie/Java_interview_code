package BinaryTree;

import com.sun.source.tree.Tree;

/**
 * @author psj
 * @date 2022/10/1 9:35
 * @File: 序列化二叉树NC123.java
 * @Software: IntelliJ IDEA
 */
public class 序列化二叉树NC123 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int index = 0;  // 字符串的下标

    void SerializeFuncation(TreeNode root, StringBuilder str) {

        if (root == null) {
            str.append("#");
            return;
        }
        // 先序遍历
        // 加上!原因是因为有些节点的值可能有多位，如果不加难以区分
        str.append(root.val).append("!");
        SerializeFuncation(root.left, str);
        SerializeFuncation(root.right, str);
    }

    TreeNode DeserializeFuncation(String str) {
        // 到达叶节点时，构建完毕，返回继续构建父节点
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }

        int val = 0;
        while (str.charAt(index) != '!' && index != str.length()) {
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }

        // 同样也是前序遍历
        TreeNode root = new TreeNode(val);
        // 序列已经构建到低了
        if (index == str.length()) {
            return root;
        } else {
            index++;
        }

        root.left = DeserializeFuncation(str);  // str不需要改变，因为有全局index
        root.right = DeserializeFuncation(str);
        return root;
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder result = new StringBuilder();
        SerializeFuncation(root, result);
        return result.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == "#") {
            return null;
        }
        TreeNode result = DeserializeFuncation(str);
        return result;
    }
}
