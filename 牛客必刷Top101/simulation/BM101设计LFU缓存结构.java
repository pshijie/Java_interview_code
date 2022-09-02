package simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author psj
 * @date 2022/8/16 12:00
 * @File: BM101设计LFU缓存结构.java
 * @Software: IntelliJ IDEA
 */
public class BM101设计LFU缓存结构 {
    class Node {
        int freq;
        int key;
        int val;

        public Node(int freq, int key, int val) {
            this.freq = freq;
            this.key = key;
            this.val = val;
        }
    }

    // 节点出现频率和对应节点集合的关系(集合中最新加入的节点放在头部)
    private Map<Integer, LinkedList<Node>> freq_map = new HashMap<>();
    // key与节点的映射关系
    private Map<Integer, Node> map = new HashMap<>();
    // 缓存剩余容量
    private int size = 0;
    // 记录当前最小频率
    private int min_freq = 0;

    public int[] LFU(int[][] operators, int k) {
        this.size = k;
        // 获取get的操作数
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] result = new int[len];

        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1)
                set(operators[i][1], operators[i][2]);
            else
                result[j++] = get(operators[i][1]);
        }
        return result;
    }

    // 更新key值对应节点的频率
    public void update(Node node, int key, int value) {
        int freq = node.freq;  // 找到节点原频率
        // 从原频率对应的节点集合中删除该节点
        freq_map.get(freq).remove(node);
        // 删除后如果该频率对应的集合中无节点，则删除该key(即删除该频率及对应的节点集合)
        if (freq_map.get(freq).isEmpty()) {
            freq_map.remove(freq);
            // 如果删除键值对是频率最小的键值对
            if (min_freq == freq) {
                min_freq++;
            }
        }
        // 如果增加的频率值(即key)并没有出现在映射中
        if (!freq_map.containsKey(freq + 1)) {
            freq_map.put(freq + 1, new LinkedList<Node>());
        }
        // 将节点插入新的集合中(插在头部)
        freq_map.get(freq + 1).addFirst(new Node(freq + 1, key, value));
        map.put(key, freq_map.get(freq + 1).getFirst());
    }

    public void set(int key, int value) {
        // 缓存中存在key，修改频率以及对应集合即可
        if (map.containsKey(key)) {
            update(map.get(key), key, value);
        } else {  // 缓存中不存在key
            // 缓存满了
            if (size == 0) {
                // 取频率最小对应的集合中的尾元素(在该集合中最早加入的元素)
                int oldkey = freq_map.get(min_freq).getLast().key;
                // 将集合中最先加入的节点删除
                freq_map.get(min_freq).removeLast();
                // 映射关系也删除
                map.remove(oldkey);
                // 删除节点后集合为空
                if (freq_map.get(min_freq).isEmpty()) {
                    freq_map.remove(min_freq);
                }
            } else {  // 缓存未满
                size--;
            }
            // 最小频率置为1
            min_freq = 1;
            // 在频率为1的双向链表表头插入该键
            if (!freq_map.containsKey(1))
                freq_map.put(1, new LinkedList<Node>());
            freq_map.get(1).addFirst(new Node(1, key, value));
            // 哈希表key值指向链表中该位置
            map.put(key, freq_map.get(1).getFirst());
        }

    }

    private int get(int key) {
        int res = -1;
        // 查找哈希表
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 根据哈希表直接获取值
            res = node.val;
            // 更新频率
            update(node, key, res);
        }
        return res;
    }
}
