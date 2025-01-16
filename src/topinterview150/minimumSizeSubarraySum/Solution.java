package topinterview150.minimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int numsLen = nums.length;
        int windowStartIdx = 0;
        int windowEndIdx = 0;
        int windowSum = nums[0];
        if (windowSum >= target) {
            return 1;
        }
        int minLen = 0;
        int windowLen;
        while (windowEndIdx < numsLen && windowStartIdx < numsLen) {
            if (windowSum >= target) {
                windowLen = windowEndIdx - windowStartIdx + 1;
                if (minLen == 0 || windowLen < minLen) {
                    minLen = windowLen;
                }
                if (minLen == 1) {
                    return 1;
                }
                windowSum -= nums[windowStartIdx];
                windowStartIdx++;
                if (windowStartIdx >= numsLen) {
                    break;
                }
                if (windowStartIdx > windowEndIdx) {
                    windowEndIdx = windowStartIdx;
                    windowSum = nums[windowEndIdx];
                }
            } else {
                windowEndIdx++;
                if (windowEndIdx >= numsLen) {
                    break;
                }
                windowSum += nums[windowEndIdx];
            }
        }
        return minLen;

        // solution for "equal to target"
        // int numsLen = nums.length;
        // int windowStartIdx = 0;
        // int windowEndIdx = 0;
        // int windowSum = nums[0];
        // if (windowSum == target) {
        //     return 1;
        // }
        // int minLen = 0;
        // int windowLen;
        // while (windowEndIdx < numsLen && windowStartIdx < numsLen) {
        //     if (windowSum < target) {
        //         windowEndIdx++;
        //         if (windowEndIdx >= numsLen) {
        //             break;
        //         }
        //         windowSum += nums[windowEndIdx];
        //     } else if (windowSum > target) {
        //         windowSum -= nums[windowStartIdx];
        //         windowStartIdx++;
        //         if (windowStartIdx >= numsLen) {
        //             break;
        //         }
        //         if (windowStartIdx > windowEndIdx) {
        //             windowEndIdx = windowStartIdx;
        //             windowSum = nums[windowEndIdx];
        //         }
        //     } else {
        //         windowLen = windowEndIdx - windowStartIdx + 1;
        //         if (minLen == 0 || windowLen < minLen) {
        //             minLen = windowLen;
        //         }
        //         if (minLen == 1) {
        //             return 1;
        //         }
        //         windowSum -= nums[windowStartIdx];
        //         windowStartIdx++;
        //         if (windowStartIdx >= numsLen) {
        //             break;
        //         }
        //         if (windowStartIdx > windowEndIdx) {
        //             windowEndIdx = windowStartIdx;
        //             windowSum = nums[windowEndIdx];
        //         }
        //     }
        // }
        // return minLen;
    }

    public static void main(String[] args) {
        new Solution().minSubArrayLen(4, new int[]{1, 4, 4});
        new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
