package DFSor回溯;

/**
 * @author psj
 * @date 2022/10/13 10:55
 * @File: 打印从1到最大的n位数.java
 * @Software: IntelliJ IDEA
 */
// 剑指offer 17
// https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/

public class 打印从1到最大的n位数 {
    // 考点在于考虑大数越界，所以需要转换为String类型
    // 当输出数字的所有位都是9时，则下个数字需要向更高位进1，此时左边界start需要减1(即高位多余的0减少一个)
    // 例如当n=3(数字范围1-999）时，比如009要进位到010，此时start需要减1
    int[] result;
    // start表示字符串中非0的第一个下标值  count表示结果集的下标  nine表示数字中9的数量
    int nine = 0, count = 0, start;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        result = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0, n);
        return result;
    }

    // x表示当前数字位数
    private void dfs(int index, int n) {
        if (index == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {
                result[count++] = Integer.parseInt(s);
            }
            // 表示当前数字除了前缀的0，其他都是'9'
            if (n - start == nine) {
                start--;
            }
            return;
        }

        for (char c : loop) {
            if (c == '9') {
                nine++;
            }
            num[index] = c;
            dfs(index + 1, n);
        }
        nine--;
    }
}
