
/**
 * @author psj
 * @date 2022/9/5 15:22
 * @File: reverseBitsInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 190
public class reverseBitsInterview {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }
}
