package BinarySearch;

/**
 * @author psj
 * @date 2022/7/16 10:02
 * @File: BM22比较版本号.java
 * @Software: IntelliJ IDEA
 */
public class BM22比较版本号 {
    public int compare(String version1, String version2) {
        // java中"\\."相当于其他语言中的"\."
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        for (int i = 0; i < a1.length || i < a2.length; i++) {
            // 如果版本号的长度较短，则补充字符串"0"
            String s1 = i < a1.length ? a1[i] : "0";
            String s2 = i < a2.length ? a2[i] : "0";
            long num1 = 0;
            long num2 = 0;
            // 将两个字符串都转为数字
            for (int j = 0; j < s1.length(); j++) {
                num1 = num1 * 10 + (s1.charAt(j) - '0');
            }
            for (int j = 0; j < s2.length(); j++) {
                num2 = num2 * 10 + (s2.charAt(j) - '0');
            }
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
