package topinterview150.triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();
        List<Integer> dp2 = new ArrayList<>();
        final int numLvs = triangle.size();
        dp.add(triangle.get(0).get(0));
        int numVals;
        List<Integer> lvVals;
        for (int lvIdx = 1; lvIdx < numLvs; lvIdx++) {
            dp2 = new ArrayList<>();
            numVals = lvIdx + 1;
            lvVals = triangle.get(lvIdx);
            dp2.add(lvVals.get(0) + dp.get(0));
            for (int valIdx = 1; valIdx < numVals - 1; valIdx++) {
                dp2.add(lvVals.get(valIdx) + Math.min(dp.get(valIdx), dp.get(valIdx - 1)));
            }
            dp2.add(lvVals.get(numVals - 1) + dp.get(numVals - 2));
            dp = dp2;
        }
        return Collections.min(dp);
    }

    public static void main(String[] args) {
        new Solution().minimumTotal(List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)));
    }
}
