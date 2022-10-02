package String;

/**
 * @author psj
 * @date 2022/10/2 9:36
 * @File: 字符串变形NC89.java
 * @Software: IntelliJ IDEA
 */
public class 字符串变形NC89 {
    public String trans(String s, int n) {
        String[] splits = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            sb.append(reverse(splits[i]));
            // 最后一个字符不添加空格
            if (i == 0) {
                break;
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    private String reverse(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}
