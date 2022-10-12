package 前缀;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/11 11:29
 * @File: 单词搜索Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// Leetcode212
// https://leetcode.cn/problems/word-search-ii/

public class 单词搜索Ⅱ {
    // 和单词搜索(DFSor回溯)不同之处在于：构建前缀树，如果当前单词不存在所有单词的前缀中，就立即停止回溯
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;  // 表示当前节对应了一个完整的单词
    }

    List<String> result = new ArrayList<>();
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    TrieNode root = new TrieNode();
    int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        // 构建前缀树
        constructTree(words);
        m = board.length;
        n = board[0].length;
        // 对每个位置进行遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root) {
        char c = board[i][j];  // 保存下来，需要回溯
        TrieNode cur = root.next[c - 'a'];
        // 如果当前位置对应了一个完整单词
        if (cur != null && cur.word != null) {
            result.add(cur.word);
            cur.word = null;  // 置空的目的在于避免相同的单词再次加入到结果集中
            // 不能return，因为可能后续还有相同前缀但是更长的单词
        }

        board[i][j] = '.';
        for (int k = 0; k < 4; k++) {
            int nI = i + dirs[k][0];
            int nJ = j + dirs[k][1];
            // 如果下个点不符合位置要求或者已经被遍历过(即已在路径中，再遍历就是走回头路)
            if ((nI < 0 || nI >= m || nJ < 0 || nJ >= n) || board[nI][nJ] == '.') {
                continue;
            }
            if (cur != null) {
                dfs(board, nI, nJ, cur);
            }
        }
        board[i][j] = c;
    }

    public void constructTree(String[] words) {
        for (String word : words) {
            TrieNode cur = this.root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = word;
        }
    }
}
