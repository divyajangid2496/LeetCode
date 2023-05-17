/**
 * 121. You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class BuySellStocks {

  public static void main(String[] args) {
    int[] prices = new int[]{7,1,5,3,6,4};

    System.out.println(maxProfit(prices));
  }

  /**
   * This method helps find the best time to buy and sell stock to maximize the profit
   *
   * Approach: The algorithm is based on the idea that the maximum profit is achieved by buying the stock at the lowest price
   * and selling it at the highest price. By continuously updating the minimum stock price and
   * calculating the potential profit at each price, the algorithm finds the maximum possible profit.
   *
   * @param prices represents the prices of stocks for n days
   * @return the maximum profit one can get by buying and selling the stocks
   */
  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minStock = prices[0];

    for(int price: prices) {
      minStock = Math.min(minStock, price);
      maxProfit = Math.max(maxProfit, price-minStock);
    }

    return maxProfit;
  }
}
