package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class Jzoffer311 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, j = 0, a = 0, b = 0;
        while (j < popped.length){
            if(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                ++j;
            } else{
                if(i < pushed.length){
                    stack.push(pushed[i]);
                    ++i;
                } else {
                    return false;
                }
            }
        }
        return i == j;
    }
}
