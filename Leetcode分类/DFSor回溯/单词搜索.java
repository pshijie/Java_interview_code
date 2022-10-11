package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/11 11:16
 * @File: 单词搜索.java
 * @Software: IntelliJ IDEA
 */
// Leetcode79
// https://leetcode.cn/problems/word-search/

public class 单词搜索 {
    // 每个点都可以是单词的起始点
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // k：当前遍历字符串中的位置
    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 判断当前遍历的位置是否在合理的位置
        // 并且需要当前位置的字符和当前遍历字符串的字符是一致的
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }

        // 将字符串的字符全部遍历完
        if (k == word.length - 1) {
            return true;
        }

        // 因为需要回溯，所以要保存当前位置的字符
        char tmp = board[i][j];
        board[i][j] = '.';
        boolean result = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return result;
    }
}
