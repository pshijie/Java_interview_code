package MapOrSet;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author psj
 * @date 2022/10/14 11:02
 * @File: 两个数组的交集.java
 * @Software: IntelliJ IDEA
 */
// Leetcode349
// https://leetcode.cn/problems/intersection-of-two-arrays/

public class 两个数组的交集 {
    // 使用集合中的API retainAll
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }

        // 求两个集合的交集，最后的set1只保留了和set2相同的数，所以后续可以直接输出set1
        set1.retainAll(set2);

        int[] result = new int[set1.size()];
        int index = 0;
        for (int n : set1) {
            result[index++] = n;
        }
        return result;
    }

}
