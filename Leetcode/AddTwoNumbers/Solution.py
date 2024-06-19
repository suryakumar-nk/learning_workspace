# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def add_two_numbers(l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    def add(a: Optional[ListNode], b: Optional[ListNode], res: Optional[ListNode], carry: int):
        if a is None and b is None:
            if carry == 0:
                return
            else:
                res.next = ListNode(carry)
                return
        if a is None:
            if carry == 0:
                res.next = b
                return
            else:
                val = b.val + carry
                if val > 9:
                    res.next = ListNode(val % 10)
                    return add(a, b.next, res.next, 1)
                else:
                    res.next = ListNode(val)
                    return add(a, b.next, res.next, 0)
        if b is None:
            if carry == 0:
                res.next = a
                return
            else:
                val = a.val + carry
                if val > 9:
                    res.next = ListNode(val % 10)
                    return add(a.next, b, res.next, 1)
                else:
                    res.next = ListNode(val)
                    return add(a.next, b, res.next, 0)

        val = a.val + b.val + carry
        if val > 9:
            res.next = ListNode(val % 10)
            return add(a.next, b.next, res.next, 1)
        else:
            res.next = ListNode(val)
            return add(a.next, b.next, res.next, 0)

    l3 = ListNode(-1)
    add(l1, l2, l3, 0)
    return l3.next


print(add_two_numbers(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4)))))
