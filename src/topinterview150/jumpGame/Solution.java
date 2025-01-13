package topinterview150.jumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        int tgt = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= tgt) {
                tgt = i;
            }
        }
        return tgt == 0;

        // n2
        // bool[] canReach = new bool[nums.length];
        // canReach[0] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {

        //     }
        // }
    }
}
