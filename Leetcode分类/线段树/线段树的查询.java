package 线段树;

/**
 * @author psj
 * @date 2022/10/23 11:01
 * @File: 线段树的构造Ⅲ.java
 * @Software: IntelliJ IDEA
 */
// lintcode202
// https://www.lintcode.com/problem/202/

public class 线段树的查询 {
    // 接受3个参数root, start和end，根据给定的线段树根找出区间[start，end]中的最大值
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

    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.max;
        }
        int nodeMid = (root.start + root.end) / 2;
        // 往左子树去找
        if (end <= nodeMid) {
            return query(root.left, start, end);
            // 往右子树去找
        } else if (start >= nodeMid + 1) {
            return query(root.right, start, end);
            // [start,end]区间与左右子树区间都存在交集
        } else {
            int leftMax = query(root.left, start, nodeMid);
            int rightMax = query(root.right, nodeMid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }
}
