package topinterview150.climbingStairs;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int prevPossible = 2;
        int prevPrevPossible = 1;
        int currPossible;
        for (int i = 3; i <= n; i++) {
            currPossible = prevPossible + prevPrevPossible;
            prevPrevPossible = prevPossible;
            prevPossible = currPossible;
        }
        return prevPossible;
    }
}
