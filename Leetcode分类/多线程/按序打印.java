package 多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author psj
 * @date 2022/10/16 11:39
 * @File: 按序打印.java
 * @Software: IntelliJ IDEA
 */
// leetcode 1114
// https://leetcode.cn/problems/print-in-order/

public class 按序打印 {
    // 方法1:使用两个变量
//    private AtomicInteger firstJobDone = new AtomicInteger(0);
//    private AtomicInteger secondJobDone = new AtomicInteger(0);
//
//    public 按序打印() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        printFirst.run();
//        firstJobDone.incrementAndGet();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (firstJobDone.get() != 1){
//            // 等待第一个任务完成
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//
//        // 开始执行第二个任务，完成后就将其加1
//        secondJobDone.incrementAndGet();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (secondJobDone.get() != 1){
//            // 等待第二个任务完成
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }

    // 方法2：使用一个变量
//    private final AtomicInteger atomic = new AtomicInteger(0);
//
//    public 按序打印() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        printFirst.run();
//        atomic.incrementAndGet();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (atomic.get() != 1) {
//            // 等待第一个任务完成
//        }
//        printSecond.run();
//        atomic.incrementAndGet();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (atomic.get() != 2) {
//            // 等待第二个任务完成
//        }
//        printThird.run();
//    }

    // 方法3：使用同步原语
//    private volatile int flag = 1;
//    private final Object object = new Object();
//
//    public 按序打印() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        synchronized (object) {
//            while (flag != 1) {
//                object.wait();
//            }
//            printFirst.run();
//            flag = 2;
//            object.notifyAll();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        synchronized (object) {
//            while (flag != 2) {
//                object.wait();
//            }
//            printSecond.run();
//            flag = 3;
//            object.notifyAll();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        synchronized (object) {
//            while (flag != 3) {
//                object.wait();
//            }
//            printThird.run();
//        }
//    }

    // 方法4：使用CountDownLatch
    private final CountDownLatch firstDone;
    private final CountDownLatch secondDone;

    public 按序打印() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.countDown();  // 将firstDone减1
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();  // 等待firstDone变为0
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.countDown();  // 将secondDone减1
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();  // 等待secondDone变为0
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
