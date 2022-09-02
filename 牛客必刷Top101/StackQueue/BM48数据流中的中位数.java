package StackQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author psj
 * @date 2022/7/25 11:20
 * @File: BM48数据流中的中位数.java
 * @Software: IntelliJ IDEA
 */
public class BM48数据流中的中位数 {
// 方法1:优先队列
//     // 小根堆存储数组中较大的值
//     PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2)->o1.compareTo(o2));
//     // 大根堆存存储数组中较小的值
//     PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2)->o2.compareTo(o1));
//     public void Insert(Integer num) {
//         // 小根堆的数量要始终大于等于大更堆
//         if (pq1.size() != pq2.size()) {
//             pq1.add(num);
//             pq2.add(pq1.poll());
//         } else {
//             pq2.add(num);
//             pq1.add(pq2.poll());
//         }
//     }

//     public Double GetMedian() {
//         return pq1.size() != pq2.size() ? pq1.peek() * 1.0 : (pq1.peek() + pq2.peek()) / 2.0;
//     }

    // 方法2:插入排序
    private ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        // 如果list为空则直接插入
        if (list.isEmpty()) {
            list.add(num);
        } else { // list存在数据则进行插入排序
            int i = 0; // i为插入点
            for (; i < list.size(); i++) {
                if (num <= list.get(i)) {
                    break;
                }
            }
            // 插入到插入点(后续元素会自动向后移动)
            list.add(i, num);
        }

    }

    public Double GetMedian() {
        int n = list.size();
        if (n % 2 == 1) {
            return list.get(n / 2) * 1.0;
        } else {
            return (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
        }
    }
}
