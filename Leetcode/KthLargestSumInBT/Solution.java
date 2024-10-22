package KthLargestSumInBT;

import java.util.Map;
import java.util.Arrays;
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

    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> levelSums = new HashMap<>();
        if (root != null)
            getSum(levelSums, 1, root);
        int n = levelSums.size();
        Long[] arr = levelSums.values().toArray(new Long[n]);
        Arrays.sort(arr);
        return arr[n-k];
    }
    
    public static void main(String[] args) {
        var treeNode = new TreeNode(1, 
                       new TreeNode(2, new TreeNode(1), new TreeNode(1)), 
                       new TreeNode(3, new TreeNode(1), new TreeNode(1)));
        System.out.println(new Solution().kthLargestLevelSum(treeNode, 2));
    }
}