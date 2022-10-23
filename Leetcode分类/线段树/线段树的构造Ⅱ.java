package 线段树;

/**
 * @author psj
 * @date 2022/10/23 10:47
 * @File: 线段树的构造Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// lintcode439
// https://www.lintcode.com/problem/439/

public class 线段树的构造Ⅱ {
    // 与线段树的构造不同，线段树的每个节点储存区间最大值, 返回根节点
    // 这里的输入是一个具体数组，不是某个数值区间，并且树的节点是数组中的下标区间

    class SegmentTreeNode {
        public int start;
        public int end;
        public int max;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = null;
            this.right = null;
        }
    }

    public SegmentTreeNode build(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        return buildTree(0, a.length - 1, a);
    }

    // 这里的start和end都是下标
    private SegmentTreeNode buildTree(int start, int end, int[] a) {
        if (start == end) {
            return new SegmentTreeNode(start, end, a[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        int mid = start + (end - start) / 2;
        root.left = buildTree(start, mid, a);
        root.right = buildTree(mid + 1, end, a);
        // 需要重新赋值root.max
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }
}
