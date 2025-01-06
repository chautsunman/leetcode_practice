package topinterview150.removeDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int prevSmallerNum = nums[0];
        int currIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prevSmallerNum) {
                nums[currIdx] = nums[i];
                prevSmallerNum = nums[currIdx];
                currIdx++;
            }
        }
        return currIdx;
    }
}
