package AllSolutions;

public class Jzoffer281 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return testRecursively(root.left,root.right);
    }

    private boolean testRecursively(TreeNode A,TreeNode B) {
        if (A == null) {
            return B == null;
        } else {
            if (B == null) {
                return false;
            }
        }
        if (A.val != B.val) {
            return false;
        }
        return testRecursively(A.left,B.right) && testRecursively(A.right,B.left);
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
