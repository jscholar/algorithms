class Solution {
  public int maxProfit(int[] prices) {
      if (prices.length == 0) {
          return 0;
      }
      
      // Keep track of maxProfit after given number of transactions
      int[][] bestProfit = new int[2][prices.length];
      int minSoFar = prices[0];
      for (int day = 1; day < prices.length; day++) {
          minSoFar = Math.min(minSoFar, prices[day]);
          bestProfit[0][day] = Math.max(
              bestProfit[0][day - 1],
              prices[day] - minSoFar
          );
      }
      
      int maxDiff = -prices[0];
      for (int day = 1; day < prices.length; day++) {
          bestProfit[1][day] = Math.max(bestProfit[1][day - 1], maxDiff + prices[day]);
          maxDiff = Math.max(maxDiff, bestProfit[0][day] - prices[day]);
      }
      
      return bestProfit[1][prices.length - 1];
  }
}