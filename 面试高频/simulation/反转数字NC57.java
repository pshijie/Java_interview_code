package simulation;

/**
 * @author psj
 * @date 2022/9/21 10:05
 * @File: 反转数字NC57.java
 * @Software: IntelliJ IDEA
 */
public class 反转数字NC57 {
    public int reverse(int x) {
//        boolean flag = false;
//        int result = 0;
//        if (x < 0) {
//            flag = true;
//            x = -x;
//        }
//
//        String str = String.valueOf(x);
//        int[] arr = new int[str.length()];
//        // 存储反转后的数字
//        int[] resArr = new int[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
//        }
//        for (int i = 0; i < str.length(); i++) {
//            resArr[i] = arr[str.length() - i - 1];
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            result = result * 10 + resArr[i];
//            // Integer.MIN_VALUE / 10 <= result <= Integer.MAX_VALUE / 10时，sum没有超过32位有符号数字的范围
//            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10)
//                return 0;
//        }
//        if (flag) {
//            result = -result;
//        }
//        return result;

        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return (int) result == result ? (int) result : 0;
    }

    public static void main(String[] args) {
        long a = 1233464848949615L;
        System.out.println((int) a);
    }
}
