package SorceToDestBinaryTree;

import SumRootOfLeafNumbers.Solution.TreeNode;

public class Solution {
    private boolean getDirection(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val)
            return true;
        if (n.left != null && getDirection(n.left, val, sb))
            sb.append("L");
        else if (n.right != null && getDirection(n.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        getDirection(root, startValue, s);
        getDirection(root, destValue, d);
        int i = 0, n = d.length() > s.length() ? d.length() : s.length();
        while (i < n && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            i++;
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(1, null, new TreeNode(3)), new TreeNode(2, new TreeNode(6, null, new TreeNode(9)), new TreeNode(4)));
        // TreeNode node = new TreeNode(1, new TreeNode(2), null);
        var sol = new Solution();
        System.out.println(sol.getDirections(node, 3, 9));
    }
}