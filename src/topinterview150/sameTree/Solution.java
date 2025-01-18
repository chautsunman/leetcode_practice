package topinterview150.sameTree;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean leftSame = false;
        if (p.left != null && q.left != null) {
            leftSame = isSameTree(p.left, q.left);
        } else if (p.left == null && q.left == null) {
            leftSame = true;
        }
        if (!leftSame) {
            return false;
        }
        boolean rightSame = false;
        if (p.right != null && q.right != null) {
            rightSame = isSameTree(p.right, q.right);
        } else if (p.right == null && q.right == null) {
            rightSame = true;
        }
        return rightSame;
    }
}
