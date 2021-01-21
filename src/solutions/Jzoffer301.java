package solutions;

import java.util.*;

public class Jzoffer301 {
    private static class MinStack {

        private final Deque<Integer> dataStack;
        private final Deque<Integer> minimalStack;

        public MinStack() {
            dataStack = new LinkedList<>();
            minimalStack = new LinkedList<>();
        }

        public void push(int x) {
            dataStack.push(x);
            x = minimalStack.isEmpty() ? x : Math.min(minimalStack.peek(), x);
            minimalStack.push(x);
        }

        public void pop() {
            if(!dataStack.isEmpty()){
                dataStack.pop();
                minimalStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minimalStack.peek();
        }
    }
}
