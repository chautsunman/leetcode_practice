package topinterview150.minimumPathSum;

import problemTypes.DynamicProgramming;

@DynamicProgramming
public class Solution {
    public int minPathSum(int[][] grid) {
        final int numRows = grid.length;
        final int numCols = grid[0].length;
        final int[][] dp = new int[numRows][numCols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < numCols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < numRows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < numCols; j++) {
                dp[i][j] = grid[i][j] + Math.min(
                        dp[i - 1][j],
                        dp[i][j - 1]
                );
            }
        }
        return dp[numRows - 1][numCols - 1];
    }

    public static void main(String[] args) {
        new Solution().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
    }
}
