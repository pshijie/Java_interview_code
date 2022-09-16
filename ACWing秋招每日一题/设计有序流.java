import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/9/7 11:49
 * @File: 设计有序流.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 1656
public class 设计有序流 {
    String[] strs;
    int k = 0;

    public 设计有序流(int n) {
        strs = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        strs[idKey - 1] = value;
        ArrayList<String> res = new ArrayList<>();
        while (k < strs.length && strs[k] != null) {
            res.add(strs[k]);
            k++;
        }
        return res;
    }
}
