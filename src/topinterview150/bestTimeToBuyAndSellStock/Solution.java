package topinterview150.bestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        int tempProfit = 0;
        int tempBuyPrice = prices[0];
        int tempBestSellPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= tempBuyPrice) {
                if (prices[i] > tempBestSellPrice) {
                    tempProfit = prices[i] - tempBuyPrice;
                    tempBestSellPrice = prices[i];
                }
            } else {
                if (tempProfit > bestProfit) {
                    bestProfit = tempProfit;
                }
                tempBuyPrice = prices[i];
                tempBestSellPrice = prices[i];
            }
        }
        if (tempProfit > bestProfit) {
            bestProfit = tempProfit;
        }
        return bestProfit;

        // incorrect solution 1: input = [2, 4, 1]
        // int minBuyPrice = prices[0];
        // int buyDay = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] < minBuyPrice) {
        //         minBuyPrice = prices[i];
        //         buyDay = i;
        //     }
        // }
        // int maxSellPrice = minBuyPrice;
        // for (int i = buyDay + 1; i < prices.length; i++) {
        //     if (prices[i] > maxSellPrice) {
        //         maxSellPrice = prices[i];
        //     }
        // }
        // return maxSellPrice - minBuyPrice;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
