package BinaryTree;

/**
 * @author psj
 * @date 2022/7/18 9:02
 * @File: BM30二叉搜索树与双向链表.java
 * @Software: IntelliJ IDEA
 */
public class BM30二叉搜索树与双向链表 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // pre记录当前节点的前一个节点，head记录头节点
    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 中序遍历二叉树
        inOrder(pRootOfTree);
        return head;
    }

    public void inOrder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        // 遍历左子树
        inOrder(curNode.left);

        // ------在遍历子树的过程中对于每一个节点依次做的操作------------
        // 没有前继节点的节点为原树的根节点
        if (pre == null) {
            head = curNode;
        } else {
            pre.right = curNode;
        }
        // 因为不管pre是否为null，curNode的left指针都要指向pre
        curNode.left = pre;
        // 更新pre
        pre = curNode;
        // ------在遍历子树的过程中对于每一个节点依次做的操作------------

        // 遍历右子树
        inOrder(curNode.right);
    }
}
