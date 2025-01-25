package problems.sortEvenAndOddIndicesIndependently;

import problemTypes.CountingSort;
import problemTypes.SortingProblem;

@SortingProblem
@CountingSort
public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        final int numsLen = nums.length;
        final int MAX_NUM = 100;
        final int[] oddCounting = new int[MAX_NUM + 1];
        final int[] evenCounting = new int[MAX_NUM + 1];
        for (int i = 0; i < numsLen; i++) {
            if (i % 2 == 0) {
                evenCounting[nums[i]]++;
            } else {
                oddCounting[nums[i]]++;
            }
        }
        for (int i = 1; i <= MAX_NUM; i++) {
            evenCounting[i] = evenCounting[i] + evenCounting[i - 1];
            oddCounting[MAX_NUM - i] = oddCounting[MAX_NUM - i] + oddCounting[MAX_NUM - i + 1];
        }
        final int[] ans = new int[numsLen];
        int tgtIdx;
        for (int i = numsLen - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                tgtIdx = evenCounting[nums[i]] - 1;
                tgtIdx = tgtIdx * 2;
                evenCounting[nums[i]]--;
                ans[tgtIdx] = nums[i];
            } else {
                tgtIdx = oddCounting[nums[i]] - 1;
                tgtIdx = tgtIdx * 2 + 1;
                oddCounting[nums[i]]--;
                ans[tgtIdx] = nums[i];
                // tgtIdx = oddCounting[nums[numsLen - i]] - 1;
                // oddCounting[nums[numsLen - i]]--;
                // tgtIdx = tgtIdx * 2 + 1;
                // ans[tgtIdx] = nums[numsLen - i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().sortEvenOdd(new int[]{4, 1, 2, 3});
    }
}
