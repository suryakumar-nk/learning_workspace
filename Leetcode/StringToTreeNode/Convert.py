#User function Template for python3
from collections import deque

class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None

def buildTree(s):
    #Corner Case
    if(len(s)==0 or s[0]=="N"):           
        return None
        
    # Creating list of strings from input 
    # string after spliting by space
    ip=list(map(str,s.split()))
    
    # Create the root of the tree
    root=Node(int(ip[0]))                     
    size=0
    q=deque()
    
    # Push the root to the queue
    q.append(root)                            
    size=size+1 
    
    # Starting from the second element
    i=1                                       
    while(size>0 and i<len(ip)):
        # Get and remove the front of the queue
        currNode=q[0]
        q.popleft()
        size=size-1
        
        # Get the current node's value from the string
        currVal=ip[i]
        
        # If the left child is not null
        if(currVal!="N"):
            
            # Create the left child for the current node
            currNode.left=Node(int(currVal))
            
            # Push it to the queue
            q.append(currNode.left)
            size=size+1
        # For the right child
        i=i+1
        if(i>=len(ip)):
            break
        currVal=ip[i]
        
        # If the right child is not null
        if(currVal!="N"):
            
            # Create the right child for the current node
            currNode.right=Node(int(currVal))
            
            # Push it to the queue
            q.append(currNode.right)
            size=size+1
        i=i+1
    return root
        
def bottomView(root):
    # code here
    def view(root, row, col, result):
        if (root.left is not None): view(root.left, row+1, col-1, result)
        if((col in result) == False):
            result[col] = (row, root.data)
        else:
            if(result[col][0] <= row):
                result[col] = (row, root.data)
        if (root.right is not None): view(root.right, row+1, col+1, result)
    
    result = {}
    view(root, 0, 0, result)
    keys = list(sorted(result.keys()))
    lis = []
    for key in keys:
        lis.append(result[key][1])
    return lis

# s='14 14 3 N 8 8 12 N 6 17 3 N 1 11 10 N 6 6 13 N 10 17 7 N 11 7'
s = '20 8 22 5 3 4 25 N N 10 14'
root=buildTree(s)
print(root)
res = bottomView(root)
for i in res:
    print (i, end = " ")
print()