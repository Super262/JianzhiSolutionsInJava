package solutions;

import java.util.Stack;

public class Jzoffer091 {

    private static class CQueue {

        // Optimization by using arrays instead of Stack<T>;
        private final int[] stack1, stack2;
        private int stack1Size, stack2Size;
        private int stack1Top, stack2Top;

        public CQueue() {
            stack1 = new int[1000];
            stack2 = new int[1000];
            stack1Size = 0;
            stack2Size = 0;
            stack1Top = -1;
            stack2Top = -1;
        }

        public void appendTail(int value) {

            // Use stack1 for input only.
            stack1[++stack1Top] = value;
            ++stack1Size;
        }

        public int deleteHead() {
            if(stack1Size < 1 && stack2Size < 1){
                return -1;
            }
            if(stack2Size < 1){
                // Use stack2 for output only.
                while(stack1Size != 0){
                    stack2[++stack2Top] = stack1[stack1Top--];
                    --stack1Size;
                    ++stack2Size;
                }
            }
            --stack2Size;
            return stack2[stack2Top--];
        }
    }
}
