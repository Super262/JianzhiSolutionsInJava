package AllSolutions;

import java.util.LinkedList;

public class Jzoffer592 {
    private static class MaxQueue {
        private final LinkedList<Integer> data;
        private final LinkedList<Integer> maxValue;

        public MaxQueue() {
            data = new LinkedList<>();
            maxValue = new LinkedList<>();
        }

        public int max_value() {
            if(maxValue.isEmpty()){
                return -1;
            } else{
                return maxValue.peekFirst();
            }
        }

        public void push_back(int value) {
            data.addLast(value);
            if(!maxValue.isEmpty() && value > maxValue.peekFirst()){
                maxValue.clear();
            } else {
                while(!maxValue.isEmpty() && maxValue.peekLast() < value){
                    maxValue.removeLast();
                }
            }
            maxValue.addLast(value);
        }

        public int pop_front() {
            if(data.isEmpty()){
                return -1;
            } else{
                int value = data.peekFirst();
                if(!maxValue.isEmpty() && value == maxValue.peekFirst()){
                    maxValue.removeFirst();
                }
                data.removeFirst();
                return value;
            }
        }
    }
}
