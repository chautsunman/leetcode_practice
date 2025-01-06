package topinterview150.majorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        // solution 1: n log n --> sort --> middle element

        final HashMap<Integer, Integer> cntMap = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (cntMap.containsKey(nums[i])) {
                cntMap.put(nums[i], cntMap.get(nums[i]) + 1);
            } else {
                cntMap.put(nums[i], 1);
            }
        }
        int threshold = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > threshold) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Solution().majorityElement(new int[]{3, 2, 3});
    }
}
