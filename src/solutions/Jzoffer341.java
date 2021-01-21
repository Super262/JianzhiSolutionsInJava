package solutions;

import java.util.LinkedList;
import java.util.List;

public class Jzoffer341 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root,int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        if (root.val == sum && root.left == null && root.right == null){
            List<Integer> tempResult = new LinkedList<>();
            tempResult.add(root.val);
            result.add(tempResult);
        } else {
            List<List<Integer>> tempResult;
            if(root.left != null){
                tempResult = pathSum(root.left, sum - root.val);
                if(tempResult.size() > 0){
                    result.addAll(tempResult);
                }
            }
            if(root.right != null){
                tempResult = pathSum(root.right, sum - root.val);
                if(tempResult.size() > 0){
                    result.addAll(tempResult);
                }
            }
            for (List path : result){
                path.add(0, root.val);
            }
        }
        return result;
    }
}
