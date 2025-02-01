package topinterview150.validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int gridLen = 9;
        final Map<Integer, Set<Integer>> rowStorage = new HashMap<>();
        final Map<Integer, Set<Integer>> colStorage = new HashMap<>();
        final Map<Integer, Set<Integer>> cellStorage = new HashMap<>();
        int cellId;
        char currChar;
        int currVal;
        Set<Integer> currStorage;
        for (int i = 0; i < gridLen; i++) {
            for (int j = 0; j < gridLen; j++) {
                cellId = getCellId(i, j);
                currChar = board[i][j];
                if (currChar == '.') {
                    continue;
                }
                currVal = currChar - '0';
                currStorage = rowStorage.getOrDefault(i, new HashSet<>());
                if (currStorage.contains(currVal)) {
                    return false;
                } else {
                    currStorage.add(currVal);
                    rowStorage.put(i, currStorage);
                }
                currStorage = colStorage.getOrDefault(j, new HashSet<>());
                if (currStorage.contains(currVal)) {
                    return false;
                } else {
                    currStorage.add(currVal);
                    colStorage.put(j, currStorage);
                }
                currStorage = cellStorage.getOrDefault(cellId, new HashSet<>());
                if (currStorage.contains(currVal)) {
                    return false;
                } else {
                    currStorage.add(currVal);
                    cellStorage.put(cellId, currStorage);
                }
            }
        }
        return true;
    }

    private int getCellId(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}
