package AllSolutions;

import java.util.LinkedList;
import java.util.Queue;

public class Jzoffer321 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> tempResult = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            tempResult.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        int[] result = new int[tempResult.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = tempResult.removeFirst();
        }
        return result;
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
