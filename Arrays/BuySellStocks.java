package Arrays;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] stockPrice = { 7, 6, 4, 3, 2, 1 };
        buyAndSellDay(stockPrice);
        maxProfit(stockPrice);
    }

    // Need to check this
    // 1st condition{7,1,5,6,3,4}
    // 2nd condition{7,6,4,3,1}
    // 3rd condition{2,4,1}
    public static void buyAndSellDay(int[] prices) {
        int buy = 0;
        int sell = 0;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[buy] > prices[i]) {
                buy = i;
            }
            if (profit < prices[i] - prices[buy]) {
                sell = i;
                profit = prices[i] - prices[buy];
            }
            if (profit <= 0) {
                buy = sell;
            }

        }

        System.out.println("Best Buy Day: " + (buy + 1) + " And Best Sell Day : " + (sell + 1));
    }

    public static void maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - buy;
            profit = Math.max(profit, cost);
            buy = Math.min(buy, prices[i]);
        }
        System.out.println("Max Profit: " + profit);
    }
}
