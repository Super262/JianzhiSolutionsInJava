package AllSolutions;

public class Jzoffer181 {
    public ListNode deleteNode(ListNode head,int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode current = head, prev = null;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                break;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
