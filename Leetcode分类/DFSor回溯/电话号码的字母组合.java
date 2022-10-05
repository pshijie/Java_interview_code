package DFSor回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/5 11:21
 * @File: 电话号码的字母组合.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 17
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/

public class 电话号码的字母组合 {
    String[] digits2String =
            // 0和1是没有对应字母的
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        char[] digitStr = digits.toCharArray();
        dfs(sb, digitStr, 0);
        return result;
    }

    private void dfs(StringBuilder sb, char[] digitStr, int index) {
        // 遍历往所有数组
        if (index == digitStr.length) {
            result.add(sb.toString());
            return;
        }

        int digit = digitStr[index] - '0';
        char[] str = digits2String[digit].toCharArray();
        for (char c : str) {
            sb.append(c);
            dfs(sb, digitStr, index + 1);
            sb.deleteCharAt(index);
        }
    }
}
