package DynamicProgram;

import java.util.ArrayList;

/**
 * @author psj
 * @date 2022/8/6 10:46
 * @File: BM74数字字符串转化成IP地址.java
 * @Software: IntelliJ IDEA
 */
public class BM74数字字符串转化成IP地址 {
    // 方法1:暴力
//     public ArrayList<String> restoreIpAddresses (String s) {
//         ArrayList<String> result = new ArrayList<>();
//         int n = s.length();
//         // 第一个IP地址末尾位置
//         for (int i = 1; i < 4 && i < n - 2; i++) {
//             // 第二个IP地址末尾位置
//             for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
//                 // 第三个IP地址末尾位置
//                 for (int k = j + 1; k < j + 4 && k < n; k++) {
//                     // 第四个IP地址长度不能大于3
//                     if (n - k >= 4) {
//                         continue;
//                     }
//                     String ip1 = s.substring(0, i);
//                     String ip2 = s.substring(i, j);
//                     String ip3 = s.substring(j, k);
//                     String ip4 = s.substring(k);
//                     // 每个IP不能大于255
//                     if (Integer.parseInt(ip1) > 255
//                             || Integer.parseInt(ip2) > 255
//                             || Integer.parseInt(ip3) > 255
//                             || Integer.parseInt(ip4) > 255) {
//                         continue;
//                     }
//                     // 排除前导0的情况，因为Integer.parseInt("012")=12
//                     if ((ip1.length() != 1 && ip1.charAt(0) == '0')
//                             || (ip2.length() != 1 && ip2.charAt(0) == '0')
//                             ||  (ip3.length() != 1 && ip3.charAt(0) == '0')
//                             || (ip4.length() != 1 && ip4.charAt(0) == '0')) {
//                         continue;
//                     }

//                     String ip = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
//                     result.add(ip);
//                 }
//             }
//         }
//         return result;
//     }

    // 方法2:回溯+剪枝
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();  // 用于存放中间结果
        dfs(s, result, temp, 0);
        return result;
    }

    public void dfs(String s, ArrayList<String> result, ArrayList<String> temp, int cur) {
        if (temp.size() == 4 && cur == s.length()) {
            result.add(temp.get(0) + '.' + temp.get(1) + '.' + temp.get(2) + '.' + temp.get(3));
            return;
        }
        // 如果剩余需要切分的字符长度超过了剩余ip需要的最大长度(即每个IP分三位)
        if (s.length() - cur > 3 * (4 - temp.size())) {
            return;
        }
        // 如果剩余需要切分的字符长度小于剩余ip需要的最短长度(即每个IP分一位)
        if (s.length() - cur < (4 - temp.size())) {
            return;
        }
        int ipAddress = 0;
        // cur为当前ip的起点,尝试以第i个位置为当前ip的结尾
        for (int i = cur; i < cur + 3 && i < s.length(); i++) {
            ipAddress = ipAddress * 10 + (s.charAt(i) - '0');
            if (ipAddress < 0 || ipAddress > 255) {
                continue;
            }
            temp.add(s.substring(cur, i + 1));
            dfs(s, result, temp, i + 1);
            temp.remove(temp.size() - 1);

            // 不允许前缀为0
            if (ipAddress == 0) {
                break;
            }
        }

    }

}
