package AllSolutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jzoffer322 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int tempValue = 0;
        int currentLevelSize = 1;
        TreeNode temp;
        LinkedList<Integer> tempResult;
        queue.add(root);
        while (!queue.isEmpty()) {
            tempResult = new LinkedList<>();
            while (currentLevelSize > 0) {
                temp = queue.poll();
                tempResult.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                    ++tempValue;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    ++tempValue;
                }
                --currentLevelSize;
            }
            currentLevelSize = tempValue;
            tempValue = 0;
            result.add(tempResult);
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
