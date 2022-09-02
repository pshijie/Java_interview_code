import java.util.Stack;

/**
 * @author psj
 * @date 2022/8/22 20:30
 * @File: NoRecursionTraverseInterview.java
 * @Software: IntelliJ IDEA
 */
// 不使用递归实现树的三种遍历
public class NoRecursionTraverseInterview {
    class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
        }
    }

    // 前序遍历
    public void preOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.val + " ");
            // 先加入右节点再加入左节点(符合栈先进后去的特性)
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    // 中序遍历
    public void inOrder(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            // 如果当前节点不为空，则将当前节点的左孩子节点入栈，并将当前节点的左孩子作为当前节点
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            // 将当前节点的值打印，并将当前节点右孩子节点作为当前节点进入下次while循环
            head = stack.pop();
            System.out.println(head.val + " ");
            head = head.right;
        }
    }

    // 后序遍历
    public void postOrder(Node head) {
        if (head == null) {
            return;
        }
        // 整体思路和前序遍历类似，只不过使用辅助栈stack2将每次stack1 pop出来的节点入栈
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        // 入辅助栈的顺序:根-》右-》左
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            // 先加入左节点再加入右节点(符合栈先进后去的特性)
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }

        // 将辅助栈的节点值依次打印即可
        // 左-》右-》根
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val + " ");
        }
    }
}
