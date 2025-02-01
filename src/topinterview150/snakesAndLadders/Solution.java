package topinterview150.snakesAndLadders;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        final int rows = board.length;
        final int cols = board[0].length;
        final int tgtVal = rows * cols;

        final Queue<Integer> exploreQueue = new ArrayDeque<>();
        final Map<Integer, Integer> visitedCellAndSteps = new HashMap<>();
        int currVal;
        int newVal;
        int[] newCoor = new int[2];

        exploreQueue.add(getCellVal(rows - 1, 0, rows, cols));
        visitedCellAndSteps.put(getCellVal(rows - 1, 0, rows, cols), 0);

        while (!exploreQueue.isEmpty()) {
            currVal = exploreQueue.poll();

            if (currVal == tgtVal) {
                return visitedCellAndSteps.get(currVal);
            }

            for (int diceRoll = 1; diceRoll <= 6; diceRoll++) {
                newVal = currVal + diceRoll;
                getCoorFromVal(newCoor, newVal, rows, cols);
                if (newVal > tgtVal) {
                    break;
                }
                if (board[newCoor[0]][newCoor[1]] != -1) {
                    newVal = board[newCoor[0]][newCoor[1]];
                    getCoorFromVal(newCoor, newVal, rows, cols);
                }
                if (!visitedCellAndSteps.containsKey(newVal)) {
                    visitedCellAndSteps.put(newVal, visitedCellAndSteps.get(currVal) + 1);
                    exploreQueue.add(newVal);
                }
            }
        }

        return -1;
    }

    private String getCellId(int row, int col) {
        return row + "," + col;
    }

    private int getCellVal(int row, int col, int rows, int cols) {
        int cellVal = 0;
        cellVal += (rows - row - 1) * cols;
        if ((rows - row - 1) % 2 == 0) {
            cellVal += col + 1;
        } else {
            cellVal += cols - col;
        }
        return cellVal;
    }

    private void getCoorFromVal(int[] coor, int val, int rows, int cols) {
        coor[0] = rows - (val - 1) / cols - 1;
        if ((rows - coor[0] - 1) % 2 == 0) {
            coor[1] = (val - 1) % cols;
        } else {
            coor[1] = cols - (val - 1) % cols - 1;
        }
    }

    public static void main(String[] args) {
        new Solution().snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        });
    }
}
