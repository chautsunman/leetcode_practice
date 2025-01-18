package topinterview150.invertBinaryTree;

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode tempNode = root.left;
        if (root.right != null) {
            root.left = invertTree(root.right);
        } else {
            root.left = null;
        }
        if (tempNode != null) {
            root.right = invertTree(tempNode);
        } else {
            root.right = null;
        }
        return root;
    }
}
