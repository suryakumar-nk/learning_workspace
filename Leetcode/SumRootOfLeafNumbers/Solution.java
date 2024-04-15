package Leetcode.SumRootOfLeafNumbers;

import java.util.ArrayList;
import java.util.List;

class Solution {

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

    private List<String> getList(TreeNode root) {
        if (root == null) return null;
        List<String> leftnums = getList(root.left);
        List<String> rightnums = getList(root.right);
        if ((leftnums == null) && (rightnums == null)) 
            return List.of(String.valueOf(root.val));

        List<String> results = new ArrayList<>();
        int rooNum = root.val;
        if (leftnums != null) {
            for(String num : leftnums) {
                results.add(rooNum+num);
            }
        }
        if (rightnums != null) {
            for(String num : rightnums) {
                results.add(rooNum+num);
            }
        }
        return results;
    }   

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        var soo = getList(root);
        for (String num : soo) {
            sum = sum + Integer.parseInt(num);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode nodes = sol.new TreeNode(0, sol.new TreeNode(1), null);
        System.out.println(sol.sumNumbers(nodes));
    }
}