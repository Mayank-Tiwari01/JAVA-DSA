package ArrayQuestions;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    static int maxProfit (int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        int len = prices.length;

        if (len == 1) {
            return 0;
        }

        while (sell < len) {
            if (prices[buy] < prices[sell]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
                sell++;
            }
            else if (prices[buy] > prices[sell]) {
                buy = sell;
                sell++;
            }
            else {
                sell++;
            }
        }
        return maxProfit;
    }
}
