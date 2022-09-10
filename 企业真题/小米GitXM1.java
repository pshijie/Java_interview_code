import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/9/10 10:52
 * @File: 小米GitXM1.java
 * @Software: IntelliJ IDEA
 */
public class 小米GitXM1 {
    public int Git(String[] matrix, int versionA, int versionB) {
        // 记录每个节点的父节点和所处层级
        int[][] tree = new int[matrix.length][2];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while (!deque.isEmpty()) {
            int cur = deque.removeFirst();
            int layer = tree[cur][1] + 1;
            for (int i = 0; i < matrix[cur].length(); i++) {
                if (matrix[cur].charAt(i) == '1' && tree[cur][0] != i) {
                    tree[i][0] = cur;
                    tree[i][1] = layer;
                    deque.addLast(i);
                }
            }
        }
        // 沿着父节点一直走直到两个层数相同？？？
        while (tree[versionA][1] > tree[versionB][1]) versionA = tree[versionA][0];
        while (tree[versionA][1] < tree[versionB][1]) versionB = tree[versionB][0];
        while (versionA != versionB) {
            versionA = tree[versionA][0];
            versionB = tree[versionB][0];
        }
        return versionA;
    }
}
