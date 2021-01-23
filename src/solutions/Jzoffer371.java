package solutions;

import java.util.LinkedList;
import java.util.Queue;

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
            if(root == null){
                return "[]";
            }
            StringBuilder result = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode current;
            queue.add(root);
            while (!queue.isEmpty()){
                current = queue.poll();
                if(current != null){
                    result.append(current.val);
                    result.append(',');
                    queue.add(current.left);
                    queue.add(current.right);
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
            if (data == null){
                return null;
            }

            final int dataLength = data.length();
            if(dataLength < 3){
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            int dataIterator = 1;
            TreeNode head = null;
            boolean onCurrentRootLeftChild = true;
            StringBuilder tempValue = new StringBuilder();


            while (dataIterator < dataLength - 1){
                switch (data.charAt(dataIterator)) {
                    case ',': {
                        ++dataIterator;
                        break;
                    }

                    case 'n': {
                        if(onCurrentRootLeftChild){
                            onCurrentRootLeftChild = false;
                        } else{
                            onCurrentRootLeftChild = true;
                            queue.poll();
                        }
                        dataIterator += 4;
                        break;
                    }

                    default: {
                        while (dataIterator <dataLength - 1 && data.charAt(dataIterator) != ','){
                            tempValue.append(data.charAt(dataIterator));
                            ++dataIterator;
                        }
                        TreeNode newNode = new TreeNode(Integer.parseInt(tempValue.toString()));
                        tempValue.setLength(0);
                        if (queue.isEmpty()){
                            head = newNode;
                        } else {
                            if (onCurrentRootLeftChild){
                                queue.peek().left = newNode;
                                onCurrentRootLeftChild = false;
                            } else {
                                queue.peek().right = newNode;
                                onCurrentRootLeftChild = true;
                                queue.poll();
                            }
                        }
                        queue.add(newNode);
                        break;
                    }
                }
            }
            return head;
        }
    }
}
