package BinaryTree;

/**
 * @author psj
 * @date 2022/7/18 9:47
 * @File: BM32合并二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM32合并二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 方法1:dfs
        // *如果一个子树为空，直接返回另一颗子树即可(不需要完全将两个子树补充为结构一致的树再进行相加)
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode head = new TreeNode(t1.val + t2.val);
        head.left = mergeTrees(t1.left, t2.left);  // 左子树和左子树相加
        head.right = mergeTrees(t1.right, t2.right);  // 右子树和右子树相加
        return head;

        // 方法2:bfs
//         if (t1 == null) {
//             return t2;
//         }
//         if (t2 == null) {
//             return t1;
//         }
//         // 将根节点进行合并
//         TreeNode head = new TreeNode(t1.val + t2.val);
//         // 存储连接后的树的层次遍历节点
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         //存储两棵树的层次遍历节点
//         Queue<TreeNode> q1 = new LinkedList<TreeNode>();
//         Queue<TreeNode> q2 = new LinkedList<TreeNode>();
//         q.offer(head);
//         q1.offer(t1);
//         q2.offer(t2);
//         while(!q1.isEmpty() && !q2.isEmpty()){
//             TreeNode node = q.poll();  // 当前要加入到连接后的树的节点
//             TreeNode node1 = q1.poll();
//             TreeNode node2 = q2.poll();
//             TreeNode left1 = node1.left;
//             TreeNode left2 = node2.left;
//             TreeNode right1 = node1.right;
//             TreeNode right2 = node2.right;
//             if(left1 != null || left2 != null){
//                 // 两个左节点都存在
//                 if(left1 != null && left2 != null){
//                     TreeNode left = new TreeNode(left1.val + left2.val);
//                     node.left = left;
//                     q.offer(left);
//                     q1.offer(left1);
//                     q2.offer(left2);
//                 // 只存在一个节点
//                 }else if(left1 != null)
//                     node.left = left1;
//                  else
//                     node.left = left2;
//             }
//             if(right1 != null || right2 != null){
//                 // 两个右节点都存在
//                 if(right1 != null && right2 != null) {
//                     TreeNode right = new TreeNode(right1.val + right2.val);
//                     node.right = right;
//                     q.offer(right);
//                     q1.offer(right1);
//                     q2.offer(right2);
//                 // 只存在一个节点
//                 }else if(right1 != null)
//                     node.right = right1;
//                  else
//                     node.right = right2;
//             }
//         }
//         return head;
    }
}
