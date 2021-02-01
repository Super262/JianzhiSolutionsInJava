package AllSolutions;

public class Jzoffer241 {
    public ListNode reverseList(final ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.next = previousNode;
        return currentNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
