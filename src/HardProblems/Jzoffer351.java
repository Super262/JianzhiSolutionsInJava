package HardProblems;

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
        HashMap<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(head, newHead);

        Node oldCurrent = head.next;
        Node newPrev = newHead;
        while(oldCurrent != null){
            Node node = new Node(oldCurrent.val);
            oldToNew.put(oldCurrent,node);
            newPrev.next = node;
            newPrev = node;
            oldCurrent = oldCurrent.next;
        }

        for(Map.Entry<Node, Node> entry : oldToNew.entrySet()){
            if(entry.getKey().random != null){
                entry.getValue().random = oldToNew.get(entry.getKey().random);
            }
        }
        return newHead;
    }
}
