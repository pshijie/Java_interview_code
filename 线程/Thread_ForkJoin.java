import java.util.Random;
import java.util.concurrent.*;

/**
 * @author psj
 * @date 2022/8/27 11:11
 * @File: Thread_ForkJoin.java
 * @Software: IntelliJ IDEA
 */
public class Thread_ForkJoin implements Calculator {
    ForkJoinPool pool;

    public Thread_ForkJoin() {
        pool = new ForkJoinPool();
    }

    private static class MyTask extends RecursiveTask<int[]> {
        int[] nums;
        int start;
        int end;

        public MyTask(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        // 归并排序代码
        @Override
        protected int[] compute() {
            if (start == end) {
                return nums;
            } else {
                int mid = (start + end) / 2;
                MyTask t1 = new MyTask(nums, start, mid);
                MyTask t2 = new MyTask(nums, mid + 1, end);
                // fork：把排序任务提交到列表中
                t1.fork();
                t2.fork();
                // join：返回任务计算结果
                int[] r1 = t1.join();
                int[] r2 = t2.join();
                int[] tmp = new int[end - start + 1];
                int i1 = start;
                int i2 = mid + 1;
                int ii = 0;
                while (i1 <= mid && i2 <= end) {
                    if (r1[i1] < r2[i2]) {
                        tmp[ii++] = r1[i1++];
                    } else {
                        tmp[ii++] = r2[i2++];
                    }
                }

                while (i1 <= mid)
                    tmp[ii++] = r1[i1++];
                while (i2 <= end)
                    tmp[ii++] = r2[i2++];

                for (int i = 0; i < tmp.length; i++) {
                    nums[i + start] = tmp[i];
                }
                return nums;
            }
        }
    }

    @Override
    public int[] sort(int[] numbers) {
        int[] res = pool.invoke(new MyTask(numbers, 0, numbers.length - 1));
        pool.shutdown();
        return res;
    }

    public static void main(String[] args) {
        int[] its = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            its[i] = random.nextInt(1000);
        }
        int[] items = new Thread_ForkJoin().sort(its);
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

interface Calculator {
    int[] sort(int[] numbers);
}