package AllSolutions;

public class Jzoffer521 {
      private static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if(headA == null || headB == null){
              return null;
          }
          ListNode node1 = headA;
          ListNode node2 = headB;
          while(true){
              if(node1 == node2){
                  return node1;
              } else {
                  node1 = node1.next;
                  node2 = node2.next;
                  if(node1 == null && node2 == null){
                      return null;
                  } else {
                      if(node1 == null){
                          node1 = headB;
                      }
                      if(node2 == null){
                          node2 = headA;
                      }
                  }
              }
          }
      }
}
