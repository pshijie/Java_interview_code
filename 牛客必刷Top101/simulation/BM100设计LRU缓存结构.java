package simulation;

import java.util.HashMap;

/**
 * @author psj
 * @date 2022/8/16 10:47
 * @File: BM100设计LRU缓存结构.java
 * @Software: IntelliJ IDEA
 */
// 关键点：构建一个HashMap和双向链表，并建立map对链表中节点的映射
//        之所以要建立Map是为了快速查找到key值对应的节点，实现get方法
public class BM100设计LRU缓存结构 {
    private HashMap<Integer, Node> map;  // 构建key->Node<key,val>之间的映射
    private DoubleList cache;
    private int cap;  // 最大容量

    public BM100设计LRU缓存结构(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        // 将该key对应的节点提升了最近使用
        return map.get(key).val;
    }

    public void set(int key, int value) {
        // map中存在原先的数据，则先从链表中删除，再加到链表末尾
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }

        // 如果空间满了则删除最久未使用元素
        if (cap == cache.size) {
            removeLeastRecently();
        }

        // 添加新元素为最久使用元素
        addRecently(key, value);
    }

    // 将某个key提升为最近使用的
    public void makeRecently(int key) {
        Node node = map.get(key);
        // 1.从链表中删除该节点
        cache.remove(node);
        // 2.重新插入队尾
        cache.addLast(node);
    }

    // 添加最近使用的元素到链表和map中
    public void addRecently(int key, int value) {
        Node node = new Node(key, value);
        cache.addLast(node);
        map.put(key, node);
    }

    // 删除某个键为key的节点
    public void deleteKey(int key) {
        Node node = map.get(key);
        // 1.从链表中删除该节点
        cache.remove(node);
        // 2.删除map中的映射
        map.remove(key);
    }

    // 删除最久未使用元素
    public void removeLeastRecently() {
        // 链表头部为最久未使用元素
        Node deleteNode = cache.removeFirst();
        // 删除该节点在map中的映射
        map.remove(deleteNode.key);
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        // 头尾虚节点
        private Node head, tail;
        // 链表节点数量
        private int size;

        // 首位节点相连
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表尾部添加节点x(在虚节点tail前添加节点x)
        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        // 删除链表的节点x
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中的第一个节点并返回
        public Node removeFirst() {
            // 链表中除了虚节点没有其他节点
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        // 返回链表长度
        public int size() {
            return size;
        }
    }

}
