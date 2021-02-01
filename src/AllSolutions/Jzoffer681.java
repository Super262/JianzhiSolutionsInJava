package AllSolutions;

import java.util.LinkedList;

public class Jzoffer681 {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();
        getPathInBST(root,p.val,pPath);
        getPathInBST(root,q.val,qPath);
        TreeNode commonNode = null;
        while (!pPath.isEmpty() && !qPath.isEmpty() && pPath.peekFirst().val == qPath.peekFirst().val) {
            commonNode = pPath.peekFirst();
            pPath.removeFirst();
            qPath.removeFirst();
        }
        return commonNode;
    }

    private boolean getPathInBST(final TreeNode root,final int target,LinkedList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            path.addFirst(root);
            return true;
        }
        if (root.val < target) {
            if (getPathInBST(root.right,target,path)) {
                path.addFirst(root);
                return true;
            } else {
                return false;
            }
        } else {
            if (getPathInBST(root.left,target,path)) {
                path.addFirst(root);
                return true;
            } else {
                return false;
            }
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
