package 多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author psj
 * @date 2022/10/14 11:11
 * @File: 哲学家进餐.java
 * @Software: IntelliJ IDEA
 */
// Leetcode1226
// https://leetcode.cn/problems/the-dining-philosophers/

public class 哲学家进餐 {
    // 通过判断哲学家的序号的奇偶性，判断先拿左边叉子还是右边叉子
    //1个叉子视为1个ReentrantLock，5个叉子即5个ReentrantLock
    private final ReentrantLock[] lockList = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };

    public 哲学家进餐() {

    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;  // 左边叉子的编号
        int rightFork = philosopher;  // 右边叉子的编号
        // 编号为偶数的哲学家，优先拿起左边的叉子，再拿起右边的叉子
        if (philosopher % 2 == 0) {
            lockList[leftFork].lock(); // 拿起左边的叉子
            lockList[rightFork].lock(); // 拿起右边的叉子
        } else {  // 编号为奇数的哲学家，优先拿起右边的叉子，再拿起左边的叉子
            lockList[rightFork].lock(); // 拿起右边的叉子
            lockList[leftFork].lock(); // 拿起左边的叉子
        }

        pickLeftFork.run();  // 拿起左边的叉子的具体执行
        pickRightFork.run();  // 拿起右边的叉子的具体执行
        eat.run();  // 吃面的具体执行

        putLeftFork.run();  // 放下左边的叉子的具体执行
        putRightFork.run();  // 放下右边的叉子的具体执行
        lockList[leftFork].unlock();  // 放下左边的叉子
        lockList[rightFork].unlock();  // 放下右边的叉子
    }
}
