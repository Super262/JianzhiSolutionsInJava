package solutions;

import java.util.Stack;

public class Jzoffer061 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        int listLen = 1;

        // Reverse the list.
        ListNode current = head;
        ListNode next = current.next, prev = null;
        while (next != null){
            ++listLen;
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;

        // Generate the result.
        int[] result = new int[listLen];
        int i = 0;
        while (current != null){
            result[i] = current.val;
            current = current.next;
            ++i;
        }
        return result;
    }
}
