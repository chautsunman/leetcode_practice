package topinterview150.uniquePaths2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int numRows = obstacleGrid.length;
        final int numCols = obstacleGrid[0].length;
        final int[] rowRemainder1Dp = new int[numCols];
        final int[] rowRemainder0Dp = new int[numCols];
        int[] prevRowDpPointer = rowRemainder0Dp;
        int[] currRowDpPointer = rowRemainder1Dp;
        prevRowDpPointer[0] = 1 - obstacleGrid[0][0];
        for (int j = 1; j < numCols; j++) {
            if (obstacleGrid[0][j] == 1) {
                prevRowDpPointer[j] = 0;
            } else {
                prevRowDpPointer[j] = prevRowDpPointer[j - 1];
            }
        }
        for (int i = 1; i < numRows; i++) {
            if (obstacleGrid[i][0] == 1) {
                currRowDpPointer[0] = 0;
            } else {
                currRowDpPointer[0] = prevRowDpPointer[0];
            }
            for (int j = 1; j < numCols; j++) {
                currRowDpPointer[j] = 0;
                if (obstacleGrid[i][j] == 0) {
                    if (currRowDpPointer[j - 1] > 0) {
                        currRowDpPointer[j] += currRowDpPointer[j - 1];
                    }
                    if (prevRowDpPointer[j] > 0) {
                        currRowDpPointer[j] += prevRowDpPointer[j];
                    }
                }
            }
            if (i % 2 == 0) {
                prevRowDpPointer = rowRemainder0Dp;
                currRowDpPointer = rowRemainder1Dp;
            } else {
                prevRowDpPointer = rowRemainder1Dp;
                currRowDpPointer = rowRemainder0Dp;
            }
        }
        return prevRowDpPointer[numCols - 1];
    }

    public static void main(String[] args) {
        new Solution().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
    }
}
