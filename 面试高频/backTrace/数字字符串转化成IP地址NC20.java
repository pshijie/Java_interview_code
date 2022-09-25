package backTrace;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/9/25 10:39
 * @File: 数字字符串转化成IP地址NC20.java
 * @Software: IntelliJ IDEA
 */
public class 数字字符串转化成IP地址NC20 {
    // 1.依次枚举这三个点的位置
    // 2.然后截取出四段数字
    // 3.比较截取出来的数字，不能大于255，且除了0以外不能有前导0，然后才能组装成IP地址加入答案中
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        int n = s.length();
        // 第一个点的位置
        for (int i = 1; i < 4 && i < n - 2; i++) {
            // 第二个点的位置
            for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                // 第三个点的位置
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    // 最后一段的数字长度不能超过3
                    if (n - k >= 4) {
                        continue;
                    }

                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);

                    // 每个数字都不能大于255
                    if (Integer.parseInt(a) > 255 || Integer.parseInt(b) > 255 || Integer.parseInt(c) > 255 || Integer.parseInt(d) > 255) {
                        continue;
                    }
                    // 排除前导为0
                    if ((a.length() != 1 && a.charAt(0) == '0') || (b.length() != 1 && b.charAt(0) == '0') || (c.length() != 1 && c.charAt(0) == '0') || (d.length() != 1 && d.charAt(0) == '0')) {
                        continue;
                    }
                    String temp = a + "." + b + "." + c + "." + d;
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
