package solutions;

public class Jzoffer071 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder,inorder,0, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder,
                                  int[] inorder,
                                  final int rootIndexInpreorder,
                                  final int firstIndexIninorder,
                                  final int lastIndexIninorder){
        if(firstIndexIninorder > lastIndexIninorder){
            return null;
        }
        final int rootValue = preorder[rootIndexInpreorder];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexIninorder = -1;
        for (int i = 0; i < inorder.length; ++i){
            if (inorder[i] == rootValue) {
                rootIndexIninorder = i;
                break;
            }
        }
        if (rootIndexIninorder > firstIndexIninorder){
            root.left = buildSubTree(preorder, inorder,
                    rootIndexInpreorder + 1, firstIndexIninorder,
                    rootIndexIninorder - 1);
        }
        if (rootIndexIninorder < lastIndexIninorder){
            root.right = buildSubTree(preorder, inorder,
                    rootIndexInpreorder + (rootIndexIninorder - firstIndexIninorder) + 1,
                    rootIndexIninorder + 1, lastIndexIninorder);
        }
        return root;
    }
}
