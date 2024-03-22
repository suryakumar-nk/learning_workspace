package Leetcode.MergingInBetweenLinkedList;

class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode mainList = list1;
        ListNode midList = list2;
        int i=1;
        while (true) {
            if (midList.next != null) midList = midList.next;
            if (i == a) {
                var tempList = mainList.next;
                mainList.next = list2;
                mainList = tempList;
            }
            if (i < b) mainList = mainList.next;
            if ((i==b) && (midList.next == null)) break;
            i++;
        }
        midList.next = mainList.next;
        return list1;
    }

    public static void main(String[] args) {
        var list1 = new ListNode(10, new ListNode(1, new ListNode(13, new ListNode(6, new ListNode(9, new ListNode(5, null))))));
        var list2 = new ListNode(44, new ListNode(55, null));
        var result = new Solution().mergeInBetween(list1, 3, 4, list2);
        System.out.println(result);
    }
}