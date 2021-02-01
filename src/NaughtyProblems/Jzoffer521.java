package NaughtyProblems;

public class Jzoffer521 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode current1 = headA;
        ListNode current2 = headB;
        while(current1 != null || current2 !=null){
            if(current1 == null){
                current1 = headB;
            }
            if(current2 == null){
                current2 = headA;
            }
            if(current1 == current2){
                return current1;
            } else{
                current1 = current1.next;
                current2 = current2.next;
            }
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
