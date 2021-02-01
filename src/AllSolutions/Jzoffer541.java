package AllSolutions;

import java.util.Stack;

public class Jzoffer541 {
    public int kthLargest(TreeNode root,int k) {
        Stack<Integer> result = new Stack<>();
        result.ensureCapacity(k);
        visitPostOrder(root,result,k);
        return result.empty() ? Integer.MIN_VALUE : result.peek();
    }

    private void visitPostOrder(TreeNode root,Stack<Integer> result,final int k) {
        if (root == null) {
            return;
        }
        visitPostOrder(root.right,result,k);
        if (result.size() != k) {
            result.push(root.val);
        }
        if (result.size() != k) {
            visitPostOrder(root.left,result,k);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
