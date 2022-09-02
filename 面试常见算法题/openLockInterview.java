import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author psj
 * @date 2022/8/23 22:35
 * @File: openLockInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 752
public class openLockInterview {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");

        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return result;
                }
                for (int j = 0; j < 4; j++) {
                    String minus = minusOne(cur, j);
                    if (!visited.contains(minus)) {
                        queue.add(minus);
                        visited.add(minus);
                    }
                    String plus = plusOne(cur, j);
                    if (!visited.contains(plus)) {
                        queue.add(plus);
                        visited.add(plus);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

    public String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }
}
