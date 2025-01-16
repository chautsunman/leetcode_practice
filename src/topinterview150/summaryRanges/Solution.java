package topinterview150.summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        final int numsLen = nums.length;
        final List<String> ranges = new ArrayList<>();
        if (numsLen <= 0) {
            return ranges;
        } else if (numsLen <= 1) {
            ranges.add("" + nums[0]);
            return ranges;
        }
        int rangeStart = nums[0];
        int rangeEnd = nums[0];
        for (int i = 1; i < numsLen; i++) {
            if (nums[i] - 1 == rangeEnd) {
                rangeEnd = nums[i];
            } else {
                if (rangeEnd == rangeStart) {
                    ranges.add("" + rangeEnd);
                } else {
                    ranges.add(rangeStart + "->" + rangeEnd);
                }
                rangeStart = nums[i];
                rangeEnd = nums[i];
            }
        }
        if (rangeEnd == rangeStart) {
            ranges.add("" + rangeEnd);
        } else {
            ranges.add(rangeStart + "->" + rangeEnd);
        }
        return ranges;
    }
}
