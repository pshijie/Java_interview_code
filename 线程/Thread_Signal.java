import java.util.concurrent.CountDownLatch;

/**
 * @author psj
 * @date 2022/8/27 10:34
 * @File: Thread_Signal.java
 * @Software: IntelliJ IDEA
 */
// 有三个线程，如何保证三个线程依次执行?
public class Thread_Signal {
    // ----------方式1:volatile+信号量---------------
//    private static volatile int count = 0;
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            while (true) {
//                if (count == 0) {
//                    for (int i = 0; i < 10; i++) {
//                        System.out.println("A - " + i);
//                    }
//                    count = 1;
//                    return;
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            while (true) {
//                if (count == 1) {
//                    for (int i = 0; i < 10; i++) {
//                        System.out.println("B - " + i);
//                    }
//                    count = 2;
//                    return;
//                }
//            }
//        });
//        Thread t3 = new Thread(() -> {
//            while (true) {
//                if (count == 2) {
//                    for (int i = 0; i < 10; i++) {
//                        System.out.println("C - " + i);
//                    }
//                    count = 3;
//                    return;
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//    }
    // ----------方式1:volatile+信号量---------------

    public static void main(String[] args) {
        CountDownLatch aLatch = new CountDownLatch(1);
        CountDownLatch bLatch = new CountDownLatch(1);
        CountDownLatch cLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            try {
                aLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("A - " + i);
            }
            bLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            try {
                bLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B - " + i);
            }
            cLatch.countDown();
        });

        Thread t3 = new Thread(() -> {
            try {
                cLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("C - " + i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        aLatch.countDown();  // 相当于开关
    }
}
