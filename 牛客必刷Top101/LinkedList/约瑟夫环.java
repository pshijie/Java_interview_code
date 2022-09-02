package LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/2 10:14
 * @File: LinkedList.约瑟夫环.java
 * @Software: IntelliJ IDEA
 */
// 已知n个人围坐在一张圆桌周围,从编号为0的人开始报1，数到m的那个人出列;
// 他的下一个人又从1开始报数，数到m的那个人又出列;依此规律重复下去，求最后留下的序号
public class 约瑟夫环 {
    // 方法1:使用单链表(取余起到循环链表的作用)
    public static void Josephus1(int n, int m) {
        List<Integer> list = new LinkedList<>();
        // 构建初始链表
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        // index表示当前要移除的元素下标
        // 下一轮之所以直接从index开始，不是从index+1开始，是因为链表移除了上一轮的index位置元素后
        // index自然就指向了原index的下一个元素
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        System.out.println("最后输出的数字是" + list.get(0));
    }

    // 方法2:递归
    public static void Josephus2(int n, int m) {
        // index表示最后剩余的元素在当前剩余数组中的下标
        // 比如到最后一轮只剩下一个元素，目标元素下标自然就是0
        // 而在上一轮中还剩两个数，目标元素在这两个元素中的下标为(0+m)%2=1(m=3)
        int index = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        // i表示当前数组长度
        for (int i = 2; i <= n; i++) {
            // 新的index = (当前index + m) % 上一轮剩余数字的个数
            index = (index + m) % i;
        }
        // 最后的index表示在初始数组中的下标位置
        System.out.println("最后输出的数字是" + index);
    }

    public static void main(String[] args) {
        Josephus1(10, 3);
        Josephus2(10, 3);
    }
}
