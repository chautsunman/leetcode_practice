package topinterview150.minimumAbsoluteDifferenceInBST;

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

    private int minDiff = Integer.MAX_VALUE;
    Integer prevVal = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minDiff;
        }

        getMinimumDifference(root.left);

        if (prevVal != null) {
            minDiff = Math.min(minDiff, root.val - prevVal);
        }
        prevVal = root.val;

        getMinimumDifference(root.right);

        return minDiff;

        // solution 1, only neighboring nodes
        // if (root == null) {
        //     return 0;
        // }
        // int minDiff = 0;
        // int subMinDiff;
        // if (root.left != null) {
        //     if (minDiff > 0) {
        //         minDiff = Math.min(minDiff, Math.abs(root.left.val - root.val));
        //     } else {
        //         minDiff = Math.abs(root.left.val - root.val);
        //     }
        //     subMinDiff = getMinimumDifference(root.left);
        //     if (subMinDiff > 0) {
        //         minDiff = Math.min(minDiff, subMinDiff);
        //     }
        // }
        // if (root.right != null) {
        //     if (minDiff > 0) {
        //         minDiff = Math.min(minDiff, Math.abs(root.right.val - root.val));
        //     } else {
        //         minDiff = Math.abs(root.right.val - root.val);
        //     }
        //     subMinDiff = getMinimumDifference(root.right);
        //     if (subMinDiff > 0) {
        //         minDiff = Math.min(minDiff, subMinDiff);
        //     }
        // }
        // return minDiff;
    }
}
