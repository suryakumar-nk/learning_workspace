package Leetcode.RemoveNthNodeFromEnd;


public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int search(ListNode head, ListNode pervious, int n, int c) {
        c = head.next == null ? 1 : search(head.next, head, n, c) + 1;
        if (c == n) {
            if (pervious == null) {
                return -1;
            } else {
                pervious.next = head.next;
            }
        }
        return c;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if (head.next == null && n == 1) return null;
        int c = search(head, null, n, 0);
        return (c == -1) ? head.next : head;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = solution.new ListNode(1, solution.new ListNode(2));
        node = solution.removeNthFromEnd(node, 2);
        System.out.println(node);
    }
}
