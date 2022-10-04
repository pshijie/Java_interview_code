package 前缀;

/**
 * @author psj
 * @date 2022/10/4 10:34
 * @File: 添加与搜索单词.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 211
// https://leetcode.cn/problems/design-add-and-search-words-data-structure/

public class 添加与搜索单词 {
    class TrieNode {
        TrieNode[] children;
        boolean flag;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root;

    public 添加与搜索单词() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] array = word.toCharArray();
        TrieNode curNode = this.root;
        for (int i = 0; i < array.length; i++) {
            // 判断当前孩子是否存在
            if (curNode.children[array[i] - 'a'] == null) {
                // 如果对应位置上不为null，则说明可以往下走
                curNode.children[array[i] - 'a'] = new TrieNode();
            }
            // 往分支继续走
            curNode = curNode.children[array[i] - 'a'];
        }
        // 表示遍历完该单词，把结束标志位置为true
        curNode.flag = true;
    }

    public boolean search(String word) {
        return searchHelp(word, root);
    }

    // 从root开始遍历，是否存在匹配word的路径
    boolean searchHelp(String word, TrieNode root) {
        char[] array = word.toCharArray();
        TrieNode curNode = root;
        for (int i = 0; i < array.length; i++) {
            // '.'因为可以匹配任意字母，所以对所有孩子开始递归遍历*
            if (array[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curNode.children[j] != null) {
                        // 只要让'.'替换其中一个字母后满足条件即可
                        if (searchHelp(word.substring(i + 1), curNode.children[j])) {
                            return true;
                        }
                    }
                }
                // 将'.'替换为任意字符后都不能匹配
                return false;
            }
            // arrat[i] != '.'，只能从孩子中找能匹配的字母
            if (curNode.children[array[i] - 'a'] == null) {
                return false;
            }
            // 找到后就沿着分支往下找
            curNode = curNode.children[array[i] - 'a'];
        }
        // 遍历完单词后要判断当前节点的标志位是否为true
        return curNode.flag;
    }
}
