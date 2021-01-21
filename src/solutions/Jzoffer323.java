package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jzoffer323 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevelSize = 1;
        int tempValue = 0;
        TreeNode tempNode;
        LinkedList<Integer> tempResult = new LinkedList<>();
        boolean toRight = true;
        queue.add(root);
        while (!queue.isEmpty()){
            while (currentLevelSize > 0){
                tempNode = queue.poll();
                --currentLevelSize;
                if(toRight){
                    tempResult.addLast(tempNode.val);
                } else {
                    tempResult.addFirst(tempNode.val);
                }
                if (tempNode.left != null){
                    queue.add(tempNode.left);
                    ++tempValue;
                }
                if (tempNode.right != null){
                    queue.add(tempNode.right);
                    ++tempValue;
                }
            }
            currentLevelSize = tempValue;
            tempValue = 0;
            result.add(tempResult);
            tempResult = new LinkedList<>();
            toRight = !toRight;
        }
        return result;
    }
}
