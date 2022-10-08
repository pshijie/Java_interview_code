package DFSor回溯;

import java.util.*;

/**
 * @author psj
 * @date 2022/10/8 10:25
 * @File: 单词矩阵.java
 * @Software: IntelliJ IDEA
 */
// 面试题17.25
// https://leetcode.cn/problems/word-rectangle-lcci/

public class 单词矩阵 {
    // *字典树
    class Trie {
        Trie[] childs;
        boolean isLeaf;

        public Trie() {
            childs = new Trie[26];
        }
    }

    Trie root;
    Map<Integer, Set<String>> map;  // key:单词长度  value：单词长度对应的单词集合
    int maxArea;
    int maxLength;  // 记录所有单词的最大长度
    List<String> result;

    public String[] maxRectangle(String[] words) {
        root = new Trie();
        map = new HashMap<>();
        result = new ArrayList<>();
        // 构建字典树
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.childs[c - 'a'] == null) {
                    // 没有对应的孩子节点则创建孩子节点
                    node.childs[c - 'a'] = new Trie();
                }
                // 往下走
                node = node.childs[c - 'a'];
            }
            // 该单词遍历完毕后将最后一个节点的isLeaf标志位置为true
            node.isLeaf = true;
        }

        // 构建单词长度和单词集合的映射
        for (String word : words) {
            int len = word.length();
            maxLength = Math.max(maxLength, len);
            Set<String> set = map.getOrDefault(len, new HashSet<>());
            set.add(word);
            map.put(len, set);
        }

        List<String> path = new ArrayList<>();
        // 对每一个不同长度的单词集合做一次回溯
        for (int key : map.keySet()) {
            path.clear();
            dfs(map.get(key), path, key);
        }

        return result.toArray(new String[result.size()]);

    }

    // dic: 当前len对应的单词集合
    private void dfs(Set<String> dic, List<String> path, int len) {
        if (len * maxLength <= maxArea) {
            return;
        }
        // 如果形成的矩阵高度已经大于最大的单词长度
        if (path.size() > maxLength) {
            return;
        }

        for (String s : dic) {
            path.add(s);
            boolean[] b = isVaild(path);
            if (b[0]) {
                int area = path.size() * path.get(0).length();
                if (b[1] && (area > maxArea)) { //每列都是单词的矩阵
                    maxArea = area;
                    result = new ArrayList<>(path);
                }
                dfs(dic, path, len);
            }
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断一个矩阵是否每一列形成的单词都在清单里
     * 存在两种情况：
     * 1.有的列中的字母不在字典树中，即这一列不可能构成单词，整个矩阵不合要求
     * 2.每列的所有字母都在字典树中但有的结尾不是leaf，也就是有的列目前还不是个单词
     * 需要一个 boolean 数组 res[]来存放结果：
     * res[0]表示是否有字母不在字典树中，true:都在，false:有不在的
     * res[1]表示是否所有的列都构成了清单里的单词
     */
    public boolean[] isVaild(List<String> input) {
        boolean allLeaf = true;
        int m = input.size();  // 每一列单词的长度
        int n = input.get(0).length();  // 一共有多少列单词
        // 检查每一列形成的单词是否在字典树中
        for (int i = 0; i < n; i++) {
            Trie node = root;
            for (int j = 0; j < m; j++) {
                int c = input.get(j).charAt(i) - 'a';
                if (node.childs[c] == null) {
                    return new boolean[]{false, false};
                }
                node = node.childs[c];
            }
            if (!node.isLeaf) {
                allLeaf = false;
            }
        }
        return new boolean[]{true, allLeaf};
    }
}
