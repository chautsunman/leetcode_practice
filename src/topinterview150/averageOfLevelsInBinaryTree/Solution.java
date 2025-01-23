package topinterview150.averageOfLevelsInBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static class TreeNode {
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

    public List<Double> averageOfLevels(TreeNode root) {
        final List<Double> avgs = new ArrayList();
        if (root == null) {
            avgs.add(0.0);
            return avgs;
        }
        final Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int lastLv = 0;
        double sum = 0.0;
        int cnt = 0;
        queue.add(new Pair(root, 0));
        Pair<TreeNode, Integer> currPair;
        TreeNode currTreeNode;
        int currLv;
        while (!queue.isEmpty()) {
            currPair = queue.poll();
            currTreeNode = currPair.getKey();
            currLv = currPair.getValue();
            if (currLv != lastLv) {
                avgs.add(sum / cnt);
                sum = currTreeNode.val;
                cnt = 1;
                lastLv = currLv;
            } else {
                sum += currTreeNode.val;
                cnt++;
            }
            if (currTreeNode.left != null) {
                queue.add(new Pair(currTreeNode.left, currLv + 1));
            }
            if (currTreeNode.right != null) {
                queue.add(new Pair(currTreeNode.right, currLv + 1));
            }
        }
        if (cnt > 0) {
            avgs.add(sum / cnt);
        }
        return avgs;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        new Solution().averageOfLevels(root);
    }
}
