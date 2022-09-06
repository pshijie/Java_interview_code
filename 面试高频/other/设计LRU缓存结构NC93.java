package other;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/9/6 9:05
 * @File: 设计LRU缓存结构NC93.java
 * @Software: IntelliJ IDEA
 */
public class 设计LRU缓存结构NC93 {
    int cap;  // 最大容量
    DoubleList cache;  // 双向链表
    HashMap<Integer, Node> map; // 快速找到Node节点

    public 设计LRU缓存结构NC93(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该节点修改为队尾元素
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
        return node.val;

    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            // 从cache和map中删除
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
            // 插入新的值到cache的末尾和map
            Node newNode = new Node(key, value);
            cache.addLast(newNode);
            map.put(key, newNode);
        } else {
            if (cap == cache.size) {
                // 删除cache的头元素
                Node removeNode = cache.removeFirst();
                map.remove(removeNode.key);
            }
            // 插入新的值到cache的末尾和map
            Node newNode = new Node(key, value);
            cache.addLast(newNode);
            map.put(key, newNode);

        }

    }

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            // 不是head.pre = tail; tail.next = head;
            head.next = tail;
            tail.pre = head;
            this.size = 0;
        }

        // 在链表尾部添加节点
        void addLast(Node x) {
            x.pre = tail.pre;
            x.next = tail;
            tail.pre.next = x;
            tail.pre = x;
            this.size++;
        }

        // 删除链表中的节点x
        void remove(Node x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            this.size--;
        }

        // 删除链表中的第一个节点并返回
        Node removeFirst() {
            if (this.head == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        int size() {
            return this.size;
        }
    }
}
