package DoulePointer;

/**
 * @author psj
 * @date 2022/9/13 11:04
 * @File: 判断是否为回文字符串NC141.java
 * @Software: IntelliJ IDEA
 */
public class 判断是否为回文字符串NC141 {
    public boolean judge(String str) {
        int left = 0;
        int right = str.length() - 1;
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
