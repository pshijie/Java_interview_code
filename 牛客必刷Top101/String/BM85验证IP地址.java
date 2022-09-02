package String;

/**
 * @author psj
 * @date 2022/8/12 11:16
 * @File: BM85验证IP地址.java
 * @Software: IntelliJ IDEA
 */
public class BM85验证IP地址 {
    public String solve(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        // 不存在"."，不是IPv4的地址
        if (IP.indexOf('.') == -1) {
            return false;
        }
        String[] ips = IP.split("\\.");
        // IPv4分割后需要为4个字符串
        if (ips.length != 4) {
            return false;
        }
        for (int i = 0; i < ips.length; i++) {
            // 校验位数
            if (ips[i].length() <= 0 || ips[i].length() > 3) {
                return false;
            }
            // 如果字符串存在多个字符但是第一个字符为0
            if (ips[i].charAt(0) == '0' && ips[i].length() != 1) {
                return false;
            }
            int num = 0;
            for (int j = 0; j < ips[i].length(); j++) {
                char c = ips[i].charAt(j);
                // 每个字符只能是数字
                if (c < '0' || c > '9') {
                    return false;
                }
                // num需要在[0, 255]范围内
                num = num * 10 + (int) (c - '0');
                if (num < 0 || num > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        // 不存在":"，不是IPv6的地址
        if (IP.indexOf(':') == -1) {
            return false;
        }
        String[] ips = IP.split(":", -1);
        // IPv6为8组
        if (ips.length != 8) {
            return false;
        }
        for (int i = 0; i < ips.length; i++) {
            // 校验位数
            if (ips[i].length() == 0 || ips[i].length() > 4) {
                return false;
            }
            // 校验字符
            for (int j = 0; j < ips[i].length(); j++) {
                // 不能出现a-fA-F以外的大小写字符
                char c = ips[i].charAt(j);
                boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
                if (!expr) {
                    return false;
                }
            }
        }
        return true;
    }
}
