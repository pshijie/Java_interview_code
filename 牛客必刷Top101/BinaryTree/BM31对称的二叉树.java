package BinaryTree;

/**
 * @author psj
 * @date 2022/7/18 9:28
 * @File: BM31对称的二叉树.java
 * @Software: IntelliJ IDEA
 */
public class BM31对称的二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        // 方法1:dfs
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);

        // 方法2:bfs
//         if(pRoot == null){
//             return true;
//         }
//         Queue<TreeNode> q1 = new LinkedList<>();
//         Queue<TreeNode> q2 = new LinkedList<>();
//         q1.offer(pRoot.left);
//         q2.offer(pRoot.right);
//         while(!q1.isEmpty() && !q2.isEmpty()){
//             // 分别从左子树和右子树队列中弹出节点
//             // 这里的leftNode和rightNode并不是指左子树的左节点和右子树的右节点
//             TreeNode leftNode = q1.poll();
//             TreeNode rightNode = q2.poll();
//             if(leftNode == null && rightNode == null){
//                 continue;
//             }
//             // 执行到该步说明不可能两个子树都为空
//             // 只有一个树的根节点为空或根节点值不同,则必定不对称
//             if(leftNode == null || rightNode == null || leftNode.val != rightNode.val){
//                 return false;
//             }
//             // 左子树队列从左向右加入节点
//             q1.offer(leftNode.left);
//             q1.offer(leftNode.right);
//             // 右子树队列从右向左加入节点
//             q2.offer(rightNode.right);
//             q2.offer(rightNode.left);
//         }
//         return true;
    }

    // 判断左右子树是否为对称的
    public boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 执行到该步说明不可能两个子树都为空
        // 只有一个树的根节点为空或根节点值不同,则必定不对称
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
