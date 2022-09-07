/**
 * @author psj
 * @date 2022/9/7 11:26
 * @File: 设计循环双端队列.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 641
public class 设计循环双端队列 {
    int[] q;
    int hh = 0, tt = 0;  // hh指向队列的头元素，tt指向队列末尾元素的下一位

    public 设计循环双端队列(int k) {
        q = new int[k + 1];  // 预留一个位置做判断是否满了
    }

    // 获得正确的下标
    public int get(int x) {
        return (x + q.length) % q.length;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        hh = get(hh - 1);
        q[hh] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        q[tt] = value;
        tt = get(tt + 1);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        hh = get(hh + 1);  // 移动下标即可表示删除
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tt = get(tt - 1);
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return q[get(hh)];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return q[get(tt - 1)];
    }

    public boolean isEmpty() {
        return hh == tt;
    }

    public boolean isFull() {
        return tt == get(hh - 1);  // 因为数组长度为k+1，所以存储了k个后数组会空出一位
    }
}
