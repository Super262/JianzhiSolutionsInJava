package AllSolutions;

public class Jzoffer361 {

    Node prev, head;

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        createDoubleList(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void createDoubleList(final Node root) {
        if (root == null){
            return;
        }
        createDoubleList(root.left);
        if(prev != null){
            prev.right = root;
        } else {
            head = root;
        }
        root.left = prev;
        prev = root;
        createDoubleList(root.right);
    }

}
