package topinterview150.convertSortedArrayToBinarySearchTree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createBSTByRange(nums, 0, nums.length);
    }

    private TreeNode createBSTByRange(int[] nums, int start, int end) {
        int rangeLen = end - start;
        if (rangeLen == 0) {
            return null;
        } else if (rangeLen == 1) {
            return new TreeNode(nums[start]);
        }
        int middleIdx = start + rangeLen / 2;
        final TreeNode left = createBSTByRange(nums, start, middleIdx);
        final TreeNode right = createBSTByRange(nums, middleIdx + 1, end);
        return new TreeNode(nums[middleIdx], left, right);
    }
}
