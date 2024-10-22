package VerticalOrderTraversalOfBT;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

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

    class Pair{
        int val;
        int row;
        int col;
        Pair(int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }
    }

    private void travel(TreeNode root, int row, int col, PriorityQueue<Pair> pq){
        if(root==null)
        return;
        pq.offer(new Pair(root.val,row,col));
        travel(root.left,row+1,col-1, pq);
        travel(root.right,row+1,col+1, pq);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
                                                                if(a.col!=b.col)
                                                                return a.col-b.col;
                                                                else
                                                                if(a.row!=b.row)
                                                                return a.row-b.row;
                                                                else
                                                                return a.val-b.val;
                                                            });
        travel(root,0,0, pq);
        while(!pq.isEmpty()){
            List<Integer> list=new ArrayList<>();
            Pair poll=pq.poll();
            list.add(poll.val);
            while(!pq.isEmpty()&&pq.peek().col==poll.col){
                list.add(pq.poll().val);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5,6,7};
        var treeNode = new TreeNode(1, 
                       new TreeNode(2, new TreeNode(4), new TreeNode(6)), 
                       new TreeNode(3, new TreeNode(5), new TreeNode(7)));
        System.out.println(new Solution().verticalTraversal(treeNode));
    }
}

// public class Solution {
//     // 1200, front and back, 670, total 10-12 copies

//     public class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode() {}
//         TreeNode(int val) { this.val = val; }
//         TreeNode(int val, TreeNode left, TreeNode right) {
//             this.val = val;
//             this.left = left;
//             this.right = right;
//         }
//     }

//     public void traversal(TreeNode root, int row, int col, Map<Integer, Map<Integer, List<Integer>>> res) {
//         if (res.containsKey(col) == false) {
//             Map<Integer, List<Integer>> rowVal = new HashMap<>();
//             List<Integer> values = new ArrayList<>();
//             values.add(root.val);
//             rowVal.put(row, values);
//             res.put(col, rowVal);
//         } else {
//             if (res.get(col).containsKey(row) == false) {
//                 List<Integer> values = new ArrayList<>();
//                 values.add(root.val);
//                 res.get(col).put(row, values);
//             } else {
//                 res.get(col).get(row).add(root.val);
//             }
//         }
//         if (root.left != null) traversal(root.left, row+1, col-1, res);
//         if (root.right != null) traversal(root.right, row+1, col+1, res);
//     }

//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         if (root == null) return List.of();
//         Map<Integer, Map<Integer, List<Integer>>> res = new HashMap<>();
//         traversal(root, 0, 0, res);
//         ArrayList<Integer> sortedKeys = new ArrayList<Integer>(res.keySet());
//         Collections.sort(sortedKeys);
//         List<List<Integer>> result = new ArrayList<>();
//         for (Integer i : sortedKeys) {
//             List<Integer> list = new ArrayList<>();
//             var rowMap = res.get(i);
//             var sortedRow = new ArrayList<Integer>(rowMap.keySet());
//             for (Integer j : sortedRow) {
//                 var lis = rowMap.get(j);
//                 Collections.sort(lis);
//                 lis.stream().forEach(l -> list.add(i));
//             }
//             result.add(list);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         List<Integer> list = new ArrayList<>();
//         list.addAll(List.of(3, 4, 5));
//         list.addAll(List.of(5,2,7,6));
//         list.addAll(List.of(3, 4, 5));
//         System.out.println(list);
//     }
// }
