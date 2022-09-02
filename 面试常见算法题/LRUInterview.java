import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/8/21 17:00
 * @File: LRUInterview.java
 * @Software: IntelliJ IDEA
 */
public class LRUInterview {
    class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node head, tail;
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }

    Map<Integer, Node> map;
    DoubleList cache;
    int cap;

    public LRUInterview(int cap) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = cap;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            delete(key);
            addRecently(key, value);
            return;
        }

        if (cap == cache.size) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        map.remove(deleteNode.key);
    }

    private void addRecently(int key, int value) {
        Node addNode = new Node(key, value);
        map.put(key, addNode);
        cache.addLast(addNode);
    }

    private void delete(int key) {
        Node cur = map.get(key);
        cache.remove(cur);
        map.remove(key);
    }

    private void makeRecently(int key) {
        Node cur = map.get(key);
        cache.remove(cur);
        cache.addLast(cur);
    }

}
