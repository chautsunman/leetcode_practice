package topinterview150.coinChange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        final int[] minConstruct = new int[amount + 1];
        minConstruct[0] = 0;
        final int coinsLen = coins.length;
        int prevAmount;
        int currMin;
        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            currMin = Integer.MAX_VALUE;
            for (int j = 0; j < coinsLen; j++) {
                prevAmount = currAmount - coins[j];
                if (prevAmount >= 0) {
                    if (minConstruct[prevAmount] != Integer.MAX_VALUE) {
                        currMin = Math.min(currMin, minConstruct[prevAmount] + 1);
                    }
                }
            }
            minConstruct[currAmount] = currMin;
        }
        if (minConstruct[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return minConstruct[amount];
    }
}
