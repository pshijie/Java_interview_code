import java.util.*;

/**
 * @author psj
 * @date 2022/9/18 10:25
 * @File: 相遇VC4.java
 * @Software: IntelliJ IDEA
 */
public class 相遇VC4 {
    static int t;
    static List<List<Integer>> maps;  // 记录每个点的出点
    static int mod = 100007;
    static Map<Integer, Integer> result = new HashMap<>();  // 记录每个点到t的路径数目

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        t = sc.nextInt() - 1;
        maps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            maps.add(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            maps.get(s).add(e);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int sp = sc.nextInt() - 1;
            System.out.println(dps(sp) % mod);
        }
    }

    // 计算出发点sp到t的路径数量
    private static int dps(int sp) {
        // 使用备忘录，没用dp
        if (result.containsKey(sp)) {
            return result.get(sp);
        }

        if (sp == t) {
            return 1;
        }

        List<Integer> temp = maps.get(sp);
        if (temp.size() == 0) {
            return 0;
        }

        int ans = 0;
        // 遍历sp点的出点到t的数量，将其全部相加
        for (int i : temp) {
            ans += dps(i) % mod;
        }

        result.put(sp, ans);
        return ans;
    }
}
