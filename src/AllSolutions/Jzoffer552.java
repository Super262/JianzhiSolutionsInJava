package AllSolutions;

public class Jzoffer552 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean[] nextTag = new boolean[1];
        int rightH = maxDepth(root.right, nextTag);
        if(nextTag[0]){
            // Break the balance.
            return false;
        }
        int leftH = maxDepth(root.left, nextTag);
        if(nextTag[0]){
            // Break the balance.
            return false;
        }
        return Math.abs(leftH - rightH) < 2;
    }
    private int maxDepth(TreeNode root, boolean[] tag) {
        if(root == null){
            return 0;
        }
        boolean[] nextTag = new boolean[1];
        int rightH = maxDepth(root.right,nextTag);
        if(nextTag[0]){
            // Break the balance.
            tag[0] = true;
            return -1;
        }
        int leftH = maxDepth(root.left, nextTag);
        if(nextTag[0]){
            // Break the balance.
            tag[0] = true;
            return -1;
        }
        if(Math.abs(leftH - rightH) < 2){
            return Math.max(leftH, rightH) + 1;
        } else {
            tag[0] = true;
            return -1;
        }
    }
}
