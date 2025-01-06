package topinterview150.removeElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (val > 50) {
            return nums.length;
        }
        int currIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currIdx] = nums[i];
                currIdx++;
            }
        }
        return currIdx;
    }
}
