package topinterview150.numberOfIslands;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int numIslands(char[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        int cnt = 0;

        final Set<String> visited = new HashSet<>();

        final int[][] directionTransforms = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    cnt++;
                    bfs_expand_island(grid, rows, cols, i, j, visited, directionTransforms);
                }
            }
        }
        return cnt;
    }

    private void bfs_expand_island(
            char[][] grid,
            int rows,
            int cols,
            int islandStartRow,
            int islandStartCol,
            Set<String> visited,
            int[][] directionTransforms
    ) {
        final Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{islandStartRow, islandStartCol});
        visited.add(islandStartRow + "," + islandStartCol);

        int[] visitingCell;
        int visitingRow;
        int visitingCol;
        int nextRow;
        int nextCol;
        while (!queue.isEmpty()) {
            visitingCell = queue.poll();
            visitingRow = visitingCell[0];
            visitingCol = visitingCell[1];
            for (int[] directionTransform : directionTransforms) {
                nextRow = visitingRow + directionTransform[0];
                nextCol = visitingCol + directionTransform[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    if (grid[nextRow][nextCol] == '1' && !visited.contains(nextRow + "," + nextCol)) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited.add(nextRow + "," + nextCol);
                    }
                }
            }
        }
    }
}
