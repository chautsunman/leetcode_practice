package topinterview150.maximumDepthOfBinaryTree;

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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = 1;
        if (root.left != null) {
            leftMax = maxDepth(root.left) + 1;
        }
        int rightMax = 1;
        if (root.right != null) {
            rightMax = maxDepth(root.right) + 1;
        }
        return Math.max(leftMax, rightMax);
    }
}
