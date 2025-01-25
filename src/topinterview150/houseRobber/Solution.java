package topinterview150.houseRobber;

import problemTypes.DynamicProgramming;

@DynamicProgramming
public class Solution {
    public int rob(int[] nums) {
        final int numsLen = nums.length;
        if (numsLen == 1) {
            return nums[0];
        } else if (numsLen == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int prevMax = Math.max(nums[0], nums[1]);
        int prevPrevMax = nums[0];
        int currMax;
        for (int i = 2; i < numsLen; i++) {
            currMax = Math.max(prevMax, prevPrevMax + nums[i]);
            prevPrevMax = prevMax;
            prevMax = currMax;
        }
        return prevMax;
    }
}
