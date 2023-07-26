from ListNode import ListNode
from typing import Optional

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if (list1 == None and list2 == None):
            return None
        if (list1 == None):
            return list2
        if (list2 == None):
            return list1
        list3 = []
        # result = None
        while (True):
            if (list1 == None):
                return Solution.createList(Solution, list3, list2)            
            if (list2 == None):
                return Solution.createList(Solution, list3, list1)
            if (list1.val ==  list2.val):
                list3.append(list1.val)
                list3.append(list2.val)
                list1 = list1.next
                list2 = list2.next
            elif (list2.val < list1.val):
                list3.append(list2.val)
                list2 = list2.next
            else:
                list3.append(list1.val)
                list1 = list1.next
    
    def createList(self, list3: list[int], result: Optional[ListNode]) -> Optional[ListNode]:
        for i in reversed(list3):
            result = ListNode(i, result)
        return result
    
a = ListNode(1, ListNode(2, ListNode(3, None)))
b = ListNode(1, ListNode(2, ListNode(3, None)))
c = Solution.mergeTwoLists(Solution, a,b)
print(c)
