package GoodLeafNodePairs;

import SumRootOfLeafNumbers.Solution.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    private int getScore(int[] left, int[] right, int distance) {
        int res = 0;
        for (int i=0; i<left.length; i++) {
            for (int j=0; j<right.length; j++) {
                if ((left[i] + right[j]) <= distance)
                    res++;
            }
        }
        return res;
    }

    private int[] getValidChild(int[] left, int[] right, int distance) {
        int[] res = new int[left.length + right.length];
        int a = 0;
        for (int val : left) {
            if (val < distance-1)
                res[a++] = val+1;
        }
        for (int val : right) {
            if (val < distance-1)
                res[a++] = val+1;
        }
        int[] newr = new int[a];
        for (int i=0; i<a; i++)
            newr[i] = res[i];
        return newr;
    }

    private int[] getChilds(TreeNode root, int distance) {
        if (root.left == null && root.right == null) {
            return new int[]{1};
        }
        int[] leftLeaves = new int[0];
        if (root.left != null) {
            leftLeaves = getChilds(root.left, distance);
        }
        int[] rightLeaves = new int[0];
        if (root.right != null) {
            rightLeaves = getChilds(root.right, distance);
        }
        result += getScore(leftLeaves, rightLeaves, distance);
        return getValidChild(leftLeaves, rightLeaves, distance);
    }

    private int result;

    public int countPairs(TreeNode root, int distance) {
        getChilds(root, distance);
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.err.println(sol.countPairs(node, 3));
    }
}