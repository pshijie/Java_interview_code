/**
 * @author psj
 * @date 2022/9/14 21:18
 * @File: 线程交替打印.java
 * @Software: IntelliJ IDEA
 */
public class 线程交替打印 {
    private static int i = 0;
    private static Object lock = new Object();
    private static final int MAX_NUM = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            while (i <= MAX_NUM) {
                synchronized (lock) {
                    if ((i & 1) == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        i++;
                        lock.notify();
                    }
                }
            }
        }, "A").start();

        new Thread(() -> {
            while (i <= MAX_NUM) {
                synchronized (lock) {
                    if ((i & 1) == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        i++;
                        lock.notify();
                    }
                }
            }
        }, "B").start();
    }
}
