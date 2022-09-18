import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author psj
 * @date 2022/9/18 11:11
 * @File: 信号覆盖VC5.java
 * @Software: IntelliJ IDEA
 */
public class 信号覆盖VC5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (k == 1) {
            System.out.println(0);
            return;
        }

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 计算每个点到其他点的距离
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = arr[i][0], y1 = arr[i][1];
            for (int j = i + 1; j < n; j++) {

                int x2 = arr[j][0], y2 = arr[j][1];
                int d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                list.add(new int[]{i, j, d});
            }
        }

        Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);

        UnionFind uf = new UnionFind(n);
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = list.get(i)[2];
            int cnt = uf.union(list.get(i)[0], list.get(i)[1]);
            if (cnt >= k) {
                break;
            }
        }
        System.out.println(result);
    }

    static class UnionFind {
        int[] parent, weight;  // weight[i]表示以i个圆心覆盖的基站数目

        public UnionFind(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int union(int idx1, int idx2) {
            int p = find(idx1);
            int q = find(idx2);
            if (p == q) {
                return weight[p];
            }
            if (weight[p] < weight[q]) {
                parent[p] = q;
                weight[q] += weight[p];
                return weight[q];
            } else {
                parent[q] = p;
                weight[p] += weight[q];
                return weight[p];
            }
        }

        // 找到idx的根节点
        private int find(int idx) {
            if (parent[idx] != idx) {
                parent[idx] = find(parent[idx]);
            }
            return parent[idx];
        }
    }
}

