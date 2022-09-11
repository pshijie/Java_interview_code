package math;

/**
 * @author psj
 * @date 2022/9/11 10:46
 * @File: 求平方根NC32.java
 * @Software: IntelliJ IDEA
 */
public class 求平方根NC32 {
    public int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int low = 1, high = x;
        // 因为当x>4时，可以证明\sqrt_x < x/2
        // 所以可以提前将high缩小一倍
        if (x > 4) {
            high = high >> 1;
        }
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);  // 加法运算符的优先级高于移位运算符
            // mid*mid <= x的话，则判断(mid+1)*(mid+1)和x的关系
            if (mid <= x / mid) {
                // (mid+1)*(mid+1) > x的话说明mid符合条件
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                    // (mid+1)*(mid+1) <= x的话说明mid小了
                } else {
                    low = mid + 1;
                }
                // mid*mid > x的话说明mid大了
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
