package solutions;

import java.util.LinkedList;

public class Jzoffer371 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private static class Codec {

        // You don't have to care about extra "null"s;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder("[");
            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode current;
            queue.addLast(root);
            while (!queue.isEmpty()){
                current = queue.removeFirst();
                if(current != null){
                    result.append(current.val);
                    result.append(',');
                    queue.addLast(current.left);
                    queue.addLast(current.right);
                } else {
                    result.append("null,");
                }
            }
            result.deleteCharAt(result.length() - 1);
            result.append(']');
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<TreeNode> nodesList = new LinkedList<>();
            TreeNode root = null;
            final int dataLen = data.length();
            int i = 1;
            boolean isNullValue = false;
            StringBuilder tempValue = new StringBuilder();
            while(i < dataLen){
                if(data.charAt(i) == 'n'){
                    i += 4;
                    isNullValue = true;
                } else if(data.charAt(i) == ',' || data.charAt(i) == ']'){
                    if(isNullValue){
                        isNullValue = false;
                        nodesList.addLast(null);
                    } else{
                        nodesList.addLast(new TreeNode(Integer.parseInt(tempValue.toString())));
                        tempValue.setLength(0);
                    }
                    ++i;
                } else {
                    tempValue.append(data.charAt(i));
                    isNullValue = false;
                    ++i;
                }
            }
            root = nodesList.removeFirst();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while(!queue.isEmpty()){
                TreeNode current = queue.removeFirst();
                if(current != null){
                    current.left = nodesList.removeFirst();
                    current.right = nodesList.removeFirst();
                    queue.addLast(current.left);
                    queue.addLast(current.right);
                }
            }
            return root;
        }
    }
}
