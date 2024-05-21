package Leetcode.MergingInBetweenLinkedList;

public class ListNode {
    int val;
    ListNode next;
    private static ListNode singleTon = null;
    ListNode() {}
    public static ListNode getInstance(int val) {
        if (singleTon == null) {
            singleTon = new ListNode(val);
        }
        return singleTon;
    }
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
