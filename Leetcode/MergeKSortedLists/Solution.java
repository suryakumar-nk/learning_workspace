package MergeKSortedLists;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];
        ListNode result = lists[0];
        ListNode tempNode = null;
        ListNode pointerNode = null;
        for (int i=1; i<n; i++) {
            ListNode currentNode = lists[i];
            if (result == null) {
                result = currentNode;
                continue;
            }
            if (currentNode == null) continue;
            while(currentNode != null && result != null) {
                if (result.val < currentNode.val) {
                    if (tempNode == null) {
                        tempNode = result;
                        pointerNode = result;
                    } else {
                        pointerNode.next = result;
                        pointerNode = result;
                    }
                    result = result.next;
                } else {
                    if (tempNode == null) {
                        tempNode = currentNode;
                        pointerNode = currentNode;
                    } else {
                        pointerNode.next = currentNode;
                        pointerNode = currentNode;
                    }
                    currentNode = currentNode.next;
                }
            }
            if (currentNode == null) {
                pointerNode.next = result;
            }
            if (result == null) {
                pointerNode.next = currentNode;
            }
            result = tempNode;
            tempNode = null;
            pointerNode = null;
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        var list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {list1, list2, null, list3};
        System.out.println(sol.mergeKLists(lists));
    }
}
