package solutions;

public class Jzoffer331 {
    public boolean verifyPostorder(int[] postorder) {
        return isValidBST(postorder, 0, postorder.length - 1);
    }
    private boolean isValidBST(int[] nodesInPostOrder, final int firstNodeIndex, final int rootIndex){
        if (firstNodeIndex >= rootIndex){
            return true;
        }

        // Find the end of left subtree.
        int leftSubTreeStart = firstNodeIndex;
        int leftSubTreeEnd = leftSubTreeStart;
        while (nodesInPostOrder[leftSubTreeEnd] < nodesInPostOrder[rootIndex]){
            ++leftSubTreeEnd;
        }
        --leftSubTreeEnd;

        // Find the end of right subtree.
        int rightSubTreeStart = leftSubTreeEnd + 1;
        int rightSubTreeEnd = rightSubTreeStart;
        while (nodesInPostOrder[rightSubTreeEnd] > nodesInPostOrder[rootIndex]){
            ++rightSubTreeEnd;
        }
        --rightSubTreeEnd;

        // You must do this first!
        // Test the root;
        if(rootIndex != (rightSubTreeEnd + 1)){
            return false;
        }

        return isValidBST(nodesInPostOrder, leftSubTreeStart, leftSubTreeEnd) && isValidBST(nodesInPostOrder, rightSubTreeStart, rightSubTreeEnd);
    }
}
