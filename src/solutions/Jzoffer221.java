package solutions;

public class Jzoffer221 {
     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }
     public ListNode getKthFromEnd(final ListNode head, int k) {
         ListNode sliceHead = head;
         ListNode sliceEnd = sliceHead;
         while (k > 0 && sliceEnd != null){
             sliceEnd = sliceEnd.next;
             --k;
         }
         if(k > 0){
             return null;
         }
         while (sliceEnd != null){
             sliceHead = sliceHead.next;
             sliceEnd = sliceEnd.next;
         }
         return sliceHead;
     }
}
