package 线段树;

/**
 * @author psj
 * @date 2022/10/23 10:40
 * @File: 线段树的构造.java
 * @Software: IntelliJ IDEA
 */
// lintcode201
// https://www.lintcode.com/problem/201/

public class 线段树的构造 {
    // 使用线段树可以快速的查找某一个节点在若干条线段中出现的次数
    // 对于线段树中的每一个非叶子节点[a,b]:
    // 它的左儿子表示的区间为[a,(a+b)/2]，右儿子表示的区间为[(a+b)/2+1,b]
    // 因此线段树是平衡二叉树，最后的子节点数目为N，即整个线段区间的长度
    // 如果a==b则说明该节点为叶子节点
    class SegmentTreeNode {
        public int start;
        public int end;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }
}
