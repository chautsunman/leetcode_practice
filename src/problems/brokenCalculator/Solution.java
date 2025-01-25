package problems.brokenCalculator;

import problemTypes.MathProblem;

@MathProblem
public class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            if (target % 2 == 1) {
                target = target + 1;
            } else {
                target = target / 2;
            }
            ans++;
        }
        return ans + (startValue - target);
    }
}
