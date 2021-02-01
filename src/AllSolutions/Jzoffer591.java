package AllSolutions;

import java.util.LinkedList;

public class Jzoffer591 {
    public int[] maxSlidingWindow(int[] nums,int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int resultTop = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
        }
        if (!q.isEmpty() && result.length > 0) {
            result[resultTop++] = q.peekFirst();
        }
        int removedNum;
        for (int i = k; i < nums.length; ++i) {
            removedNum = nums[i - k];
            if (!q.isEmpty() && removedNum == q.peekFirst()) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.removeLast();
            }
            q.addLast(nums[i]);
            if (!q.isEmpty() && result.length > 0) {
                result[resultTop++] = q.peekFirst();
            }
        }
        return result;
    }
}
