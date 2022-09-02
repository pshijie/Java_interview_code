package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/10 11:03
 * @File: BM80买卖股票的最好时机Ⅰ.java
 * @Software: IntelliJ IDEA
 */
public class BM80买卖股票的最好时机Ⅰ {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            // 寻找遍历到prices[i]时的最低点
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                // 计算后续比minPrice大的prices[i]具体比minPrice大多少
            } else if (prices[i] - minPrice > result) {
                result = prices[i] - minPrice;
            }
        }
        return result;
    }
}
