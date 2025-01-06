package topinterview150.removeDuplicatesFromSortedArray2;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int prevSmallerNum = nums[0];
        int currIdx = 1;
        int currNumCnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prevSmallerNum) {
                nums[currIdx] = nums[i];
                prevSmallerNum = nums[currIdx];
                currIdx++;
                currNumCnt = 1;
            } else if (currNumCnt <= 1) {
                nums[currIdx] = prevSmallerNum;
                currIdx++;
                currNumCnt++;
            }
        }
        return currIdx;
    }
}
