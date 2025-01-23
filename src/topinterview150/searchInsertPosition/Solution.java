package topinterview150.searchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsertWithRange(nums, 0, nums.length, target);
    }

    private int searchInsertWithRange(int[] nums, int start, int end, int target) {
        final int rangeLen = end - start;
        if (rangeLen == 0) {
            return start;
        } else if (rangeLen == 1) {
            if (target == nums[start]) {
                return start;
            } else if (target < nums[start]) {
                return start;
            } else {
                return end;
            }
        }
        final int middleIdx = start + rangeLen / 2;
        if (target == nums[middleIdx]) {
            return middleIdx;
        } else if (target < nums[middleIdx]) {
            return searchInsertWithRange(nums, start, middleIdx, target);
        } else {
            return searchInsertWithRange(nums, middleIdx + 1, end, target);
        }
    }
}
