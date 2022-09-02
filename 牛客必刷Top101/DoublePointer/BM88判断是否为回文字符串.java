package DoublePointer;

/**
 * @author psj
 * @date 2022/8/12 11:52
 * @File: BM88判断是否为回文字符串.java
 * @Software: IntelliJ IDEA
 */
public class BM88判断是否为回文字符串 {
    public boolean judge(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
