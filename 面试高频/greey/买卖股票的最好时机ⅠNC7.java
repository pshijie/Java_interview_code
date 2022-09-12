package greey;

/**
 * @author psj
 * @date 2022/9/12 9:32
 * @File: 买卖股票的最好时机ⅠNC7.java
 * @Software: IntelliJ IDEA
 */
public class 买卖股票的最好时机ⅠNC7 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                result = Math.max(prices[i] - minPrice, result);
            } else {
                minPrice = prices[i];
            }
        }
        return result;
    }
}
