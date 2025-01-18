package topinterview150.symmetricTree;

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            return false;
        }
        if (root.left != null && root.right == null) {
            return false;
        }
        return isSymmetricLeftRight(root.left, root.right);
    }

    private boolean isSymmetricLeftRight(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean outerSymmetric = false;
        if (left.left != null && right.right != null) {
            outerSymmetric = isSymmetricLeftRight(left.left, right.right);
        } else if (left.left == null && right.right == null) {
            outerSymmetric = true;
        }
        if (!outerSymmetric) {
            return false;
        }
        boolean innerSymmetric = false;
        if (left.right != null && right.left != null) {
            innerSymmetric = isSymmetricLeftRight(left.right, right.left);
        } else if (left.right == null && right.left == null) {
            innerSymmetric = true;
        }
        return innerSymmetric;
    }
}
