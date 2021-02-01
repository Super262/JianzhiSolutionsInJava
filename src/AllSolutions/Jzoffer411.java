package AllSolutions;

import java.util.PriorityQueue;

public class Jzoffer411 {
    private static class MedianFinder {

        private final PriorityQueue<Integer> smallerOnes;
        private final PriorityQueue<Integer> largerOnes;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            smallerOnes = new PriorityQueue<>((x,y) -> (y - x));
            largerOnes = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (smallerOnes.isEmpty() && largerOnes.isEmpty()) {
                smallerOnes.add(num);
                return;
            }
            if (!smallerOnes.isEmpty() && num < smallerOnes.peek()) {
                smallerOnes.add(num);
            } else {
                largerOnes.add(num);
            }
            if (smallerOnes.size() - largerOnes.size() > 1) {
                largerOnes.add(smallerOnes.poll());

            } else if (largerOnes.size() - smallerOnes.size() > 1) {
                smallerOnes.add(largerOnes.poll());
            }
        }

        public double findMedian() {
            if (smallerOnes.isEmpty() && largerOnes.isEmpty()) {
                return 0.0;
            }
            if (smallerOnes.size() > largerOnes.size()) {
                return (double) (smallerOnes.peek());
            } else if (largerOnes.size() > smallerOnes.size()) {
                return (double) (largerOnes.peek());
            } else {
                return (double) (smallerOnes.peek() + largerOnes.peek()) / 2;
            }
        }
    }
}
