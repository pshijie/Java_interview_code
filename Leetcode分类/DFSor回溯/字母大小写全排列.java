package DFSor回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/8 11:25
 * @File: 字母大小写全排列.java
 * @Software: IntelliJ IDEA
 */
// Leetcode784
// https://leetcode.cn/problems/letter-case-permutation/

public class 字母大小写全排列 {
    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        char[] path = new char[s.length()];
        dfs(s, 0, path);
        return result;
    }

    private void dfs(String s, int begin, char[] path) {
        if (begin == s.length()) {
            result.add(new String(path));
            return;
        }

        path[begin] = s.charAt(begin);
        dfs(s, begin + 1, path);  // 不转换大小写往下遍历(也是结果)
        // 如果当前遍历的元素是字母
        if (Character.isLetter(s.charAt(begin))) {
            // 进行大小写转换后再往下遍历
            // *大小写转换使用1<<5，比如A的二进制是01000001，和100000异或后为a的二进制01100001(即65+32=97)
            // 同理如果是a的二进制01100001，和100000异或后变为A的二进制01000001
            path[begin] = (char) (s.charAt(begin) ^ (1 << 5));
            dfs(s, begin + 1, path);
        }
        // 不需要回溯，一直往下遍历即可
    }
}
