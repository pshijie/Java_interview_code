package String;

/**
 * @author psj
 * @date 2022/8/11 11:10
 * @File: BM83字符串变形.java
 * @Software: IntelliJ IDEA
 */
public class BM83字符串变形 {
    public String trans(String s, int n) {
        String[] strArray = s.split(" ", -1);

        StringBuilder strbuild = new StringBuilder();

        for (int i = strArray.length - 1; i >= 0; i--) {
            strbuild.append(reverse(strArray[i])); // 数组转换为字符串
            //最后一个字符串后面不再附加空格
            if (i == 0) {
                break;
            }
            //字符串之间附加空格
            strbuild.append(" ");
        }
        return strbuild.toString();
    }

    // 大小写转换
    private String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                res.append(Character.toUpperCase(ch));
                continue;
            }
            if (Character.isUpperCase(ch)) {
                res.append(Character.toLowerCase(ch));
                continue;
            }
        }
        return res.toString();
    }
}
