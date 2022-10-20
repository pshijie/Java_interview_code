package BFS;

import java.util.HashSet;
import java.util.List;

/**
 * @author psj
 * @date 2022/10/20 10:01
 * @File: 丢手绢.java
 * @Software: IntelliJ IDEA
 */
// lintcode1269
// https://www.lintcode.com/problem/1269/

public class 丢手绢 {
    // 把N个人抽象为图的节点，丢手绢的方向抽象为边，将该图视为解决有向图上最小环问题
    public int gameTurns(List<Integer> to) {
        int minTurn = to.size();
        // 需要从每个节点都出发一次，判断能否到达该点，可以的话再记录走过边的长度
        for (int i = 0; i < to.size(); i++) {
            // pos记录当前到达的位置
            int pos = i;
            int turnCount = 0;
            HashSet<Integer> visited = new HashSet<>();
            pos = to.get(pos);
            turnCount++;
            while (pos != i) {
                pos = to.get(pos);
                turnCount++;
                // 如果到了已访问过的点，代表这个手绢进入死循环，到不了出发点
                if (visited.contains(pos)) {
                    break;
                }
                visited.add(pos);
            }
            // 回到起点
            if (pos == i) {
                minTurn = Math.min(minTurn, turnCount);
            }
        }
        return minTurn;
    }
}
