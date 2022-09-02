package DynamicProgram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/8/9 11:13
 * @File: BM76正则表达式匹配.java
 * @Software: IntelliJ IDEA
 */
public class BM76正则表达式匹配 {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean match(String str, String pattern) {
        return dp(str, 0, pattern, 0);
    }

    // dp(s,i,p,j)表示s[i...]可以匹配p[j...]
    public boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        // p字符串已经匹配完
        if (j == n) {
            return i == m;
        }
        // 如果s遍历
        if (i == m) {
            // p剩余字符数目为奇数,则无法匹配
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 剩余字符串出现连续两个字母,无法匹配
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = s.charAt(i) + "," + p.charAt(j);
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                return dp(s, i, p, j + 2) || // 通配符*匹配0次
                        dp(s, i + 1, p, j);  // 通配符*匹配多次
            } else {
                return dp(s, i + 1, p, j + 1);  // 正常字母的匹配
            }
        } else {  // s[i]!=p[j]且p[j]!='.'
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 通配符*只能匹配0次
                res = dp(s, i, p, j + 2);
            } else {  // 没有通配符*,字母也无法正常匹配
                res = false;
            }
        }

        memo.put(key, res);

        return res;
    }
}
