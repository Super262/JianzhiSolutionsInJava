package solutions;

public class Jzoffer251 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 != null ? l1 : l2;
        return fakeHead.next;
    }
}
