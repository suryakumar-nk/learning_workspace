from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def distributeCoins(root: Optional[TreeNode]) -> int:
    def get(root, parent):
        if root==None: return 0
        moves=get(root.left, root)+get(root.right, root)
        x=root.val-1
        if parent!=None: parent.val+=x
        moves+=abs(x)
        return moves
    return get(root, None)

treNode = TreeNode(0, TreeNode(2, TreeNode(2)), TreeNode(0))
print(distributeCoins(treNode))