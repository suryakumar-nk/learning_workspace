package CousinsInBT;

import java.util.Map;
import java.util.HashMap;

import SumRootOfLeafNumbers.Solution.TreeNode;

public class Solution {
    
    private void getSum(Map<Integer, Long> levelSums, int level, TreeNode node) {
        if (levelSums.containsKey(level)) {
            levelSums.put(level, levelSums.get(level)+node.val);
        } else {
            levelSums.put(level, (long) node.val);
        }
        if (node.left != null)
            getSum(levelSums, level+1, node.left);
        if (node.right != null)
            getSum(levelSums, level+1, node.right);
    }

    private void replaceValues(Map<Integer, Long> levelSums, TreeNode node, int level, int pairValue) {
        if (node == null)
            return;
        node.val = levelSums.get(level).intValue() - node.val - pairValue;
        int leftVal = node.left != null ? node.left.val : 0;
        int rightVal = node.right != null ? node.right.val : 0;
        replaceValues(levelSums, node.right, level+1, leftVal);
        replaceValues(levelSums, node.left, level+1, rightVal);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Long> levelSums = new HashMap<>();
        if (root != null)
            getSum(levelSums, 1, root);
        replaceValues(levelSums, root, 1, 0);
        return root;
    }

    public static void main(String[] args) {
        var treeNode = new TreeNode(5, 
                       new TreeNode(4, new TreeNode(1), new TreeNode(10)), 
                       new TreeNode(9, null, new TreeNode(7)));
        new Solution().replaceValueInTree(treeNode);
        System.out.println(treeNode);
    }
}
