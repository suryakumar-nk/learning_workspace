package FlipEquivelentBT;

import SumRootOfLeafNumbers.Solution.TreeNode;

public class Solution {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        System.out.println(root1.val+" == "+root2.val);
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);    
        // return (root1 == null && root2 == null) ? true :
        //        (root1 == null || root2 == null) ? false :
        //        (root1.val != root2.val) ? false : 
        //        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
    
    public static void main(String[] args) {
        var root1 = new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(4), 
                        new TreeNode(5, new TreeNode(7), new TreeNode(8))
                        ),
                    new TreeNode(3, new TreeNode(6), null));
        var root2 = new TreeNode(1,
                    new TreeNode(3, null, new TreeNode(6)),
                    new TreeNode(2, 
                        new TreeNode(5, new TreeNode(8), new TreeNode(7)),
                        new TreeNode(4)
                        ));
        System.out.println(new Solution().flipEquiv(root1, root2));
    }
}
