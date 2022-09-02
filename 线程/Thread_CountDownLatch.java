import java.lang.annotation.Target;
import java.util.concurrent.CountDownLatch;

/**
 * @author psj
 * @date 2022/8/27 9:43
 * @File: Thread_CountDownLatch.java
 * @Software: IntelliJ IDEA
 */
// 有三个线程，如何保证三个线程同时执行?
public class Thread_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        Thread_CountDownLatch thread_countDownLatch = new Thread_CountDownLatch();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    // 使当前线程进入同步队列进行等待，直到latch的值被减到0,当前线程就会被唤醒
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis());
            }).start();
        }

        Thread.sleep(100);
        // 使latch的值减1，如果减到了0则会唤醒所有等待在这个latch上的线程
        countDownLatch.countDown();
    }
}
