import java.util.Scanner;
import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/20 10:57
 * @File: 愤怒的小鸟VC6.java
 * @Software: IntelliJ IDEA
 */
public class 愤怒的小鸟VC6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = sc.nextInt();
        }
        // 存储下标，不是存储高度
        Stack<Integer> s = new Stack<>();
        // left[i]表示左边第一个比第i个位置高的元素位置
        int[] left = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            while (!s.isEmpty() && array[s.peek()] <= array[i]) {
                s.pop();
            }
            // 0表示不存在
            left[i] = s.isEmpty() ? 0 : s.peek();
            s.push(i);
        }
        s.clear();
        // right[i]表示右边第一个比第i个位置高的元素位置
        int[] right = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            while (!s.isEmpty() && array[s.peek()] <= array[i]) {
                s.pop();
            }
            // 0表示不存在
            right[i] = s.isEmpty() ? n + 1 : s.peek();
            s.push(i);
        }

        // 差分数组
        int[] result = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            result[0] += 1;
            result[left[i] + 1] -= 1;
            result[right[i]] += 1;
        }

        for (int i = 1; i <= n; i++) {
            result[i] += result[i - 1];
            System.out.print(result[i] + " ");
        }
    }
}
