package 前缀;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/3 10:33
 * @File: 数飞机.java
 * @Software: IntelliJ IDEA
 */
// 给出飞机的起飞和降落时间的列表，用序列interval表示，请计算出天上同时最多有多少架飞机

public class 数飞机 {
    class Interval {
        int start;
        int end;
    }

    // 方法1:前缀和
    // 在开始时间位置+1架飞机，在结束时间-1架飞机，求一遍前缀和就是对应时间飞机数
    public int countOfAirplanes(List<Interval> airplanes) {
        int[] num = new int[1110100];
        int max = 0;
        for (int i = 0; i < airplanes.size(); i++) {
            num[airplanes.get(i).start] += 1;
            num[airplanes.get(i).end] -= 1;
            max = Math.max(max, airplanes.get(i).end);
        }
        int result = 0;
        // 计算出max是为了不完全遍历数组
        for (int i = 0; i <= max; i++) {
            if (i != 0) {
                num[i] += num[i - 1];
            }
            result = Math.max(result, num[i]);
        }
        return result;
    }

    // 方法2:扫描线
    // 把飞机的开始时间和结束时间都封装为一个对象
    // 对排好序的飞机进行扫描：扫描到开始时间飞机数+1,扫描到结束时间飞机数-1
    static class Node {
        public int time;
        public int cost;

        public Node() {
        }

        // 开始时间cost为1，结束时间cost为-1
        public Node(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

    //先按照时间升序，再按照cost升序排序
    static Comparator<Node> cNode = new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            if (o1.time != o2.time) {
                return o1.time - o2.time;
            }
            return o1.cost - o2.cost;
        }
    };

    public int countOfAirplanes_scanLine(List<Interval> airplanes) {
        ArrayList<Node> room = new ArrayList<>();
        // 将开始时间和结束时间都作为对象，并不是将其存储在同一个对象中
        for (int i = 0; i < airplanes.size(); i++) {
            room.add(new Node(airplanes.get(i).start, 1));
            room.add(new Node(airplanes.get(i).end, -1));
        }
        Collections.sort(room, cNode);

        int result = 0;
        int temp = 0;
        for (int i = 0; i < room.size(); i++) {
            temp += room.get(i).cost;
            result = Math.max(result, temp);
        }
        return result;
    }
}