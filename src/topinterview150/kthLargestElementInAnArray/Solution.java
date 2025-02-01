package topinterview150.kthLargestElementInAnArray;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int numsLen = nums.length;
        final PriorityQueue<Integer> heap = new PriorityQueue(numsLen, Collections.reverseOrder());
        for (int i = 0; i < numsLen; i++) {
            heap.add(nums[i]);
        }
        while (k > 1) {
            heap.poll();
            k--;
        }
        return heap.peek();
    }
}
