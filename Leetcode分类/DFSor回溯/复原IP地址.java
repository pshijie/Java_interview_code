package DFSor回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/9 11:28
 * @File: 复原IP地址.java
 * @Software: IntelliJ IDEA
 */
// Leetcode93
// https://leetcode.cn/problems/restore-ip-addresses/

public class 复原IP地址 {
    // 树的每一层的含义就是当前IpSegment可能的数字串
    // 与之前的回溯不同的地方在于需要加入剩余IpSegment的个数，用于判断剩余数字串的合法性以及结果合法性的判断
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len > 12 || len < 4) {
            return result;
        }
        ArrayDeque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path);
        return result;
    }

    // *residue：记录还剩余多少段没有被分割
    private void dfs(String s, int len, int begin, int residue, ArrayDeque<String> path) {
        if (begin == len) {
            if (residue == 0) {
                // 将path中每个字符串进行拼接
                result.add(String.join(".", path));
                return;
            }
        }
        // 每一层表示当前段可以被分到的数字，比如255235241261，则第一段可以被分到2，25，255
        // 2，25，255这三个数字串的begin位置是不同的
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            // IP地址剩余数字大于剩余段需要的最大数字长度
            // 比如还剩下一段需要分配，最大只需要3个数字，此时还剩下4个就不满足了
            if (residue * 3 < len - i) {
                continue;
            }
            if (judgeIpSegment(s, begin, i)) {
                String curIpSegment = s.substring(begin, i + 1);
                path.addLast(curIpSegment);
                dfs(s, len, i + 1, residue - 1, path);
                path.removeLast();
            }

        }
    }

    // 判断s中[left,right]之间是否合法
    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        // 如果[left，right]不止存储一个数字，但是这串数字开头就是0，不满足IP地址要求
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int result = 0;
        // 计算s中[left,right]的数字串大小
        while (left <= right) {
            result = result * 10 + s.charAt(left) - '0';
            left++;
        }
        // IP每一段需要满足在[0,255]之间
        return result >= 0 && result <= 255;
    }
}
