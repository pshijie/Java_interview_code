import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/9/6 10:47
 * @File: 用户分组.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1282
public class 用户分组 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new LinkedList<>();
        HashMap<Integer, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int x = groupSizes[i];
            // 构建空链表
            if (hash.get(x) == null) {
                hash.put(x, new ArrayList<>());
            }
            hash.get(x).add(i);
            // 每次取到了指定的长度后，就重置链表
            if (hash.get(x).size() == x) {
                res.add(hash.get(x));
                hash.put(x, null);
            }
        }
        return res;
    }
}
