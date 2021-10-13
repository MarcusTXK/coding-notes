package array.easy;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class BestTimeToBuyAndSellStock_121 {
    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public int maxProfit(int[] prices) {
        int smallestValue = prices[0];
        int largestDifference = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentValue = prices[i];
            if (currentValue < smallestValue) {
                smallestValue = currentValue;
            }
            largestDifference = Math.max(prices[i] - smallestValue, largestDifference);
        }
        return largestDifference;
    }
}
