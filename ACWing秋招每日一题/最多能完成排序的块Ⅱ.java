import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author psj
 * @date 2022/9/6 11:00
 * @File: 最多能完成排序的块Ⅱ.java
 * @Software: IntelliJ IDEA
 */
public class 最多能完成排序的块Ⅱ {
    public int maxChunksToSorted(int[] arr) {
        // 方法1：map
//        // 记录两个数组(一个排好序，一个未排序)元素频次之差
////        HashMap<Integer, Integer> cnt = new HashMap<>();
////        int res = 0;
////        int[] sortedArr = new int[arr.length];
////        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
////        Arrays.sort(sortedArr);
////        for (int i = 0; i < arr.length; i++) {
////            int x = arr[i];
////            int y = sortedArr[i];
////            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
////            if (cnt.get(x) == 0) {
////                cnt.remove(x);
////            }
////            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
////            if (cnt.get(y) == 0) {
////                cnt.remove(y);
////            }
////            if (cnt.isEmpty()) {
////                res++;
////            }
////        }
////        return res;

        // 方法2:单调栈
        // 这个栈存储每个块的最大值
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            // 如果当前数大于当前块的最大元素(栈顶元素)，它就可以自己形成一个块
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                int max = stack.pop();
                // 如果当前数小于当前块的最大元素(栈顶元素)
                // 它不能自己形成一个块，需要加入到某个块中
                // 该块中的最大值要小于等于当前数
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}
