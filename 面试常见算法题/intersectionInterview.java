import java.util.HashSet;
import java.util.Set;

/**
 * @author psj
 * @date 2022/8/24 22:56
 * @File: intersectionInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 349
public class intersectionInterview {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            getIntersection(set2, set1);
        }

        Set<Integer> set = new HashSet<>();

        for (int i : set1) {
            if (set2.contains(i)) {
                set.add(i);
            }
        }
        int[] result = new int[set.size()];

        int index = 0;
        for (int i : set) {
            result[index++] = i;
        }
        return result;
    }
}
