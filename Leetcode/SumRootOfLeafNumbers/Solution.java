package SumRootOfLeafNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
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
        TreeNode nodes = new TreeNode(0, new TreeNode(1), null);
        System.out.println(sol.sumNumbers(nodes));
    }
}