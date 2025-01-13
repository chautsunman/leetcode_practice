package topinterview150.jumpGame2;

public class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currRangeStart = 0;
        int currRangeEnd = 0;
        int farthest;
        while (currRangeEnd < nums.length - 1) {
            farthest = 0;
            for (int i = currRangeStart; i <= currRangeEnd; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            currRangeStart = currRangeEnd + 1;
            currRangeEnd = farthest;
            jumps++;
        }
        return jumps;

        // n2
        // left to right
        // curr = min(curr + 1, ..., curr + j) + 1
    }
}
