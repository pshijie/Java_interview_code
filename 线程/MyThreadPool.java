import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * @author psj
 * @date 2022/9/2 15:50
 * @File: MyThreadPool.java
 * @Software: IntelliJ IDEA
 */
// 实现一个简易线程池,主要步骤：
// 1.每当添加一个任务，就会从线程池中取一个工作线程去处理执行它。
// 2.没有任务处理时，工作线程应该处于阻塞状态等待任务到来，不会竞争占用CPU资源
// 3.线程池相当于生产-消费模型，只不过生产线程的中生产任务不同罢了

// 线程池：创建工作线程并管理，添加任务，并且销毁所有工作线程
public class MyThreadPool {
    // 创建线程安全的任务队列,保证多个线程对这个队列操作时是线程安全的
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    // 线程管理列表,这个列表保存了所有线程对象的引用，方便后续的管理
    private List<Worker> Workers = new ArrayList<>();
    // 线程池最大允许的个数
    private static final int MAXWorkerCount = 10;

    // 创建线程并执行任务
    public void execute(Runnable command) throws InterruptedException {
        if (Workers.size() < MAXWorkerCount) {
            // 创建新的工作线程
            Worker worker = new Worker(queue, Workers.size());
            worker.start();
            Workers.add(worker);
        }
        queue.put(command);  // 将任务添加到任务队列中
    }

    // 销毁所有线程:只是将线程状态设置为中断，并且让主线程阻塞所有工作线程
    public void shutDown() throws InterruptedException {
        // 将线程的状态置为中断
        for (Worker worker : Workers) {
            worker.interrupt();
        }
        // 并且让主线程join阻塞等待所有工作线程
        for (Worker worker : Workers) {
            worker.join();
        }

        System.out.println("工作线程销毁完毕!");
    }


    // 测试方法
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool();
        for (int i = 0; i < 100; i++) {
            myThreadPool.execute(new MyRunnable(i+1));
        }
        Thread.sleep(2000);  // 主线程休眠
        myThreadPool.shutDown();  // 销毁所有工作线程
        System.out.println("线程池被销毁");
    }
}

// 工作线程Worker,负责从阻塞任务队列中取出任务执行
class Worker extends Thread {
    // 阻塞任务队列:可以保证多个线程对队列操作， 线程安全
    private BlockingQueue<Runnable> queue = null;

    // 每个工作线程都会有一个阻塞队列，这个队列中保存了所有的任务
    public Worker(BlockingQueue<Runnable> queue, int id) {
        this.queue = queue;
        Thread.currentThread().setName("psj_" + id);
    }

    // 工作线程执行内容
    @Override
    public void run() {
        // 每个线程通过isInterrupted()判断线程异常状态
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable command = queue.take();  // 如果队列为空，take会让线程阻塞
                System.out.println(Thread.currentThread().getName() + "正在处理任务");
                command.run();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中止了");
            }
        }
    }
}

// 自定义任务
class MyRunnable implements Runnable {
    private int num;

    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行任务:" + num);
    }
}
