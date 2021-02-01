package AllSolutions;

import java.util.HashMap;
import java.util.Map;

public class Jzoffer351 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node newHead = new Node(head.val);
        HashMap<Node, Node> oldVersusNew = new HashMap<>();
        oldVersusNew.put(head, newHead);
        Node oldCurrent = head.next;
        Node newPrev = newHead;
        Node newCurrent;
        while (oldCurrent != null){
            newCurrent = new Node(oldCurrent.val);
            oldVersusNew.put(oldCurrent, newCurrent);
            oldCurrent = oldCurrent.next;
            newPrev.next = newCurrent;
            newPrev = newCurrent;
        }
        for(Map.Entry<Node, Node> entry : oldVersusNew.entrySet()){
            if(entry.getKey().random != null){
                entry.getValue().random = oldVersusNew.get(entry.getKey().random);
            }
        }
        return newHead;
    }

}
