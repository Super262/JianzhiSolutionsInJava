package AllSolutions;

public class Jzoffer271 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tempLeft = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tempLeft);
        return root;
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
