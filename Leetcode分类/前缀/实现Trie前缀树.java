package 前缀;

/**
 * @author psj
 * @date 2022/10/4 10:20
 * @File: 实现Trie前缀树.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 208
// https://leetcode.cn/problems/implement-trie-prefix-tree/

public class 实现Trie前缀树 {
    class TrieNode {
        // R links to node children
        // 相当于一个26叉树
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public 实现Trie前缀树() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containsKey(curChar)) {
                node.put(curChar, new TrieNode());
            }
            node = node.get(curChar);  // 沿着该分支往下走
        }
        // 走完这个单词后设置end标志位
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        // 除了判断有前缀外，还有判断遍历完单词后正好走到的当前节点的标志位是否为true
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            // 沿着分支完下走
            if (node.containsKey(curChar)) {
                node = node.get(curChar);
            } else {
                return null;  // 没有前缀
            }
        }
        return node;
    }
}
