package topinterview150.longestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        final int numsLen = nums.length;
        final int[] longestSeq = new int[numsLen];
        Arrays.fill(longestSeq, 1);
        for (int i = 0; i < numsLen; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && longestSeq[j] + 1 > longestSeq[i]) {
                    longestSeq[i] = longestSeq[j] + 1;
                }
            }
        }
        int maxLongestSeq = 0;
        for (int i = 0; i < numsLen; i++) {
            if (longestSeq[i] > maxLongestSeq) {
                maxLongestSeq = longestSeq[i];
            }
        }
        return maxLongestSeq;

//        final int numsLen = nums.length;
//        final int[] longestSeq = new int[numsLen];
//        longestSeq[0] = 1;
//        int longestSeqEndIdx = 0;
//        int currSeqStart = 0;
//        for (int i = 1; i < numsLen; i++) {
//            if (nums[i] <= nums[i - 1]) {
//                longestSeq[i] = longestSeq[i - 1];
//                currSeqStart = i;
//            } else {
//                if (nums[i] > nums[longestSeqEndIdx]) {
//                    longestSeq[i] = longestSeq[longestSeqEndIdx] + 1;
//                    longestSeqEndIdx = i;
//                } else {
//                    if (i - currSeqStart + 1 >= longestSeq[longestSeqEndIdx]) {
//                        longestSeq[i] = i - currSeqStart + 1;
//                        longestSeqEndIdx = i;
//                    } else {
//                        longestSeq[i] = longestSeq[longestSeqEndIdx];
//                    }
//                }
//            }
//        }
//        return longestSeq[numsLen - 1];
    }

    public static void main(String[] args) {
        new Solution().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
        new Solution().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    }
}
