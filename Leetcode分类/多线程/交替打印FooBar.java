package 多线程;

import java.util.concurrent.Semaphore;

/**
 * @author psj
 * @date 2022/10/17 11:38
 * @File: 交替打印FooBar.java
 * @Software: IntelliJ IDEA
 */
// Leetcode1115
// https://leetcode.cn/problems/print-foobar-alternately/

public class 交替打印FooBar {
//    // 方法1：synchronized
//    private int n;
//    private boolean fooTurn = true;
//    private Object lock = new Object();
//
//    public 交替打印FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (lock) {
//                // 当fooTrun为true时才能往下执行业务代码
//                if (!fooTurn) {
//                    lock.wait();
//                }
//                fooTurn = false;
//                // printFoo.run() outputs "foo". Do not change or remove this line.
//                printFoo.run();
//                lock.notifyAll();
//            }
//
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (lock){
//                // 当fooTrun为false时才能往下执行业务代码
//                if (fooTurn){
//                    lock.wait();  // 等待线程1释放lock资源
//                }
//                fooTurn = true;
//                // printBar.run() outputs "bar". Do not change or remove this line.
//                printBar.run();
//
//                lock.notifyAll();
//            }
//        }
//    }

    // 方法2：Semaphore
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);  // 需要先执行foo方法，所以这里设置为0

    public 交替打印FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}
