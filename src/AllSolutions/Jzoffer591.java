package AllSolutions;

import java.util.Deque;
import java.util.LinkedList;

public class Jzoffer591 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < k; ++i){
            addEleToDeque(nums[i], deque);
        }
        if(!deque.isEmpty()){
            result[0] = deque.peekFirst();
        }

        for(int i = 1; i < result.length; ++i){
            if(!deque.isEmpty() && nums[i - 1] == deque.peekFirst()){
                deque.removeFirst();
            }
            result[i] = addEleToDeque(nums[i + k - 1], deque);
        }

        return result;
    }

    private int addEleToDeque(int ele, Deque<Integer> deque){
        if(deque.isEmpty()){
            deque.addFirst(ele);
        } else {
            if(ele > deque.peekFirst()){
                deque.clear();
                deque.addFirst(ele);
            } else{
                while(!deque.isEmpty() && deque.peekLast() < ele){
                    deque.removeLast();
                }
                deque.addLast(ele);
            }
        }
        if(!deque.isEmpty()){
            return deque.peekFirst();
        } else {
            return -1;
        }
    }
}
