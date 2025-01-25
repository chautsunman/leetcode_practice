package problems.findTheSmallestDivisorGivenAThreshold;

import problemTypes.BinarySearch;

@BinarySearch
public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        final int numsLen = nums.length;
        int rangeStart = 1;
        int rangeEnd = 0;
        for (int i = 0; i < numsLen; i++) {
            if (nums[i] > rangeEnd) {
                rangeEnd = nums[i];
            }
        }
        int middle;
        int currSum;
        int ans = Integer.MAX_VALUE;
        while (rangeStart <= rangeEnd) {
            middle = (rangeEnd - rangeStart) / 2 + rangeStart;
            currSum = calcSum(nums, numsLen, (double) middle);
            if (currSum <= threshold) {
                ans = middle;
                rangeEnd = middle - 1;
            } else {
                rangeStart = middle + 1;
            }
        }
        return ans;
    }

    private int calcSum(int[] nums, int numsLen, double divisor) {
        int sum = 0;
        for (int i = 0; i < numsLen; i++) {
            sum += (int) Math.ceil(nums[i] / divisor);
        }
        return sum;
    }
}
