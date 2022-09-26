package simulation;

import java.util.*;

/**
 * @author psj
 * @date 2022/9/26 8:54
 * @File: 设计LFU缓存结构NC94.java
 * @Software: IntelliJ IDEA
 */
public class 设计LFU缓存结构NC94 {
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

    // 操作频率到双向链表的hash表
    Map<Integer, LinkedList<Node>> freq_map = new HashMap<>();
    // key到节点的hash表
    Map<Integer, Node> map = new HashMap<>();
    // 缓存剩余容量
    int size = 0;
    // 记录最小频次
    int min_freq = 0;

    public int[] LFU(int[][] operators, int k) {
        this.size = k;

        // 获取get操作了几次
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] result = new int[len];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                result[j++] = get(operators[i][1]);
            }
        }
        return result;
    }

    // 更新key值对应的节点频率
    void update(Node node, int key, int value) {
        // 节点原频率
        int freq = node.freq;
        // 从原频率对应的节点集合中删除该节点
        freq_map.get(freq).remove(node);
        // 删除后如果频率对应的集合为空，就删除该key
        if (freq_map.get(freq).isEmpty()) {
            freq_map.remove(freq);
            // 如果删除的键值对是频率最小的键值对，要更新当前的最小频率值
            if (min_freq == freq) {
                min_freq++;
            }
        }

        // 如果增加的频率值并没有出现在hash表中
        if (!freq_map.containsKey(freq + 1)) {
            freq_map.put(freq + 1, new LinkedList<Node>());
        }

        // 将节点插入新的集合中(插在头部)
        freq_map.get(freq + 1).addFirst(new Node(freq + 1, key, value));
        map.put(key, freq_map.get(freq + 1).getFirst());

    }

    void set(int key, int value) {
        // 缓存中存在key,修改对应hash表
        if (map.containsKey(key)) {
            update(map.get(key), key, value);
        } else {
            // 缓存满了
            if (size == 0) {
                // 取频率最小的集合中的尾元素(在该集合中最早加入的元素)
                int oldKey = freq_map.get(min_freq).getLast().key;
                // 将该元素从频率集合中删除
                freq_map.get(min_freq).removeLast();
                // 同时删除映射关系
                map.remove(oldKey);
                // 如果删除后集合为空，就删除该键值对
                if (freq_map.get(min_freq).isEmpty()) {
                    freq_map.remove(min_freq);
                }
                // 缓存未满
            } else {
                size--;
            }
            // 当前元素是第一次出现的元素，所以最小频率设为1
            min_freq = 1;
            // 在hash表中插入频率为1的键值对
            if (!freq_map.containsKey(1)) {
                freq_map.put(1, new LinkedList<Node>());
            }
            freq_map.get(1).addFirst(new Node(1, key, value));
            // 同时更新位置hash表
            map.put(key, freq_map.get(1).getFirst());
        }
    }

    int get(int key) {
        int result = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            result = node.val;
            // 因为操作了该元素，所以需要更新
            update(node, key, result);
        }
        return result;
    }
}
