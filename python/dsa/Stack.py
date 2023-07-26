class Stack:
    def __init__(self, v=None):
        self.value = v
        self.next = None
        return
    
    def isempty(self):
        if self.value == None:
            return(True)
        return(False)
    
    def push(self, v):
        if self.isempty():
            self.value = v
        else:
            newStack = Stack(v)
            (self.value, newStack.value) = (newStack.value, self.value)
            (self.next, newStack.next) = (newStack, self.next)

    def pop(self):
        if self.isempty():
            return()
        elif self.next == None:
            return (self.value)
        else:
            node = self.value
            self.value = self.next.value
            self.next = self.next.next
            return (node)

    def __str__(self):
        selflist = []
        if self.value == None:
            return(str(selflist))
        
        temp = self
        selflist.append(temp.value)
        
        while temp.next != None:
            temp = temp.next
            selflist.append(temp.value)

        return(str(selflist))

# from Node import *

# list = Node(5)
# list.append(7)
# list.insert(8)
# list.__str__()