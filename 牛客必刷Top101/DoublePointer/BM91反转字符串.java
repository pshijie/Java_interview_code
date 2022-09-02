package DoublePointer;

/**
 * @author psj
 * @date 2022/8/13 11:29
 * @File: BM91反转字符串.java
 * @Software: IntelliJ IDEA
 */
public class BM91反转字符串 {
    public String solve(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
