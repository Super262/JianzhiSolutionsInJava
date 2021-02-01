package AllSolutions;

public class Jzoffer261 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure (final TreeNode A, final TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        if (A.val == B.val && BIsPartOfA(A, B)){
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean BIsPartOfA(final TreeNode A,final TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return BIsPartOfA(A.left, B.left) && BIsPartOfA(A.right, B.right);
    }
}
