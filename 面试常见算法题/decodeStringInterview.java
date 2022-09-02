import java.util.Stack;

/**
 * @author psj
 * @date 2022/8/23 21:51
 * @File: decodeStringInterview.java
 * @Software: IntelliJ IDEA
 */
// Leetcode 394
public class decodeStringInterview {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                String bucketLetters = "";  // 存储括号内的字母
                while (!stack.peek().equals("[")) {
                    bucketLetters = stack.pop() + bucketLetters;
                }
                stack.pop();  // 将左括号弹出
                String cnts = "";  // 存储一个/一串字符
                while (!stack.isEmpty() &&
                        stack.peek().charAt(0) >= '0' &&
                        stack.peek().charAt(0) <= '9') {
                    cnts = stack.pop() + cnts;
                }
                int cnt = Integer.parseInt(cnts);
                StringBuilder sub = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    sub.append(bucketLetters);
                }
                // 如果是子嵌套则将解析后的字符串再次放入stack中
                if (!s.isEmpty()) {
                    stack.push(sub.toString());
                } else {  // 直接加入结果即可
                    result.append(sub.toString());
                }
            } else {
                stack.push(c + "");
            }
        }
        String remainSub = "";
        while (!stack.isEmpty()) {
            remainSub = stack.pop() + remainSub;
        }
        result.append(remainSub);

        return result.toString();
    }
}
