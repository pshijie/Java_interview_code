/**
 * @author psj
 * @date 2022/8/21 1:09
 * @File: ProducerConsumer.java
 * @Software: IntelliJ IDEA
 */
// 使用wait-notifyAll实现
public class 生产者消费者模式 {
    public static void main(String[] args) {
        // 同一个仓库
        BufferArea ba = new BufferArea();

        //三个生产者
        Producer p1 = new Producer(ba);
        Producer p2 = new Producer(ba);
        Producer p3 = new Producer(ba);
        //三个消费者
        Consumer c1 = new Consumer(ba);
        Consumer c2 = new Consumer(ba);
        Consumer c3 = new Consumer(ba);
        //创建线程，并给线程命名
        Thread t1 = new Thread(p1, "生产者1");
        Thread t2 = new Thread(p2, "生产者2");
        Thread t3 = new Thread(p3, "生产者3");
        Thread t4 = new Thread(c1, "消费者1");
        Thread t5 = new Thread(c2, "消费者2");
        Thread t6 = new Thread(c3, "消费者3");
        //使线程进入就绪状态
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

// 生产者
class Producer implements Runnable {

    private BufferArea ba;

    public Producer(BufferArea ba) {
        this.ba = ba;
    }

    @Override
    public void run() {
        while (true) {
            setIntervalTime();
            ba.set();  // 每个一段时间去生产商品
        }
    }

    // 设置时间间隔
    public void setIntervalTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


// 消费者
class Consumer implements Runnable {
    private BufferArea ba;

    public Consumer(BufferArea ba) {
        this.ba = ba;
    }

    @Override
    public void run() {
        while (true) {
            setIntervalTime();
            ba.get();  // 从仓库中取商品
        }
    }

    // 设置时间间隔
    public void setIntervalTime() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 缓存区
class BufferArea {
    private int curNum = 0;  // 当前仓库商品数量
    private int maxNum = 10;  // 仓库最大商品数量

    // 生产者生产商品
    public synchronized void set() {
        if (curNum < maxNum) {
            curNum++;
            System.out.println(Thread.currentThread().getName() + "生产了一件产品！当前产品数为:" + curNum);
            notifyAll();
        } else {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始等待！当前仓库已满，产品数为：" + curNum);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者消费商品
    public synchronized void get() {
        // 仓库还有商品
        if (curNum > 0) {
            curNum--;
            System.out.println(Thread.currentThread().getName() + " 获得了一件产品！当前产品数为：" + curNum);
            notifyAll();
        } else {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始等待！当前仓库为空，产品数为：" + curNum);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}