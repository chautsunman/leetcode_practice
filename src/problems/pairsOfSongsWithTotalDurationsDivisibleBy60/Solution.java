package problems.pairsOfSongsWithTotalDurationsDivisibleBy60;

import problemTypes.MathProblem;
import problemTypes.PrevArrayMemory;

import java.util.HashMap;
import java.util.Map;

@MathProblem
@PrevArrayMemory
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        final int timeLen = time.length;
        final Map<Integer, Integer> remainderCnts = new HashMap<>();
        remainderCnts.put(time[0] % 60, 1);
        int numPairs = 0;
        int currRemainder;
        int currTgt;
        for (int i = 1; i < timeLen; i++) {
            currRemainder = time[i] % 60;
            currTgt = (60 - currRemainder) % 60;
            if (remainderCnts.containsKey(currTgt)) {
                numPairs += remainderCnts.get(currTgt);
            }
            if (remainderCnts.containsKey(currRemainder)) {
                remainderCnts.put(currRemainder, remainderCnts.get(currRemainder) + 1);
            } else {
                remainderCnts.put(currRemainder, 1);
            }
        }
        return numPairs;

        // trivial solution: n2
    }
}
