package AllSolutions;

public class Jzoffer511 {
    private int mergeSort(int[] nums,final int start,final int end,int[] temp) {
        int pairsCount = 0;
        if (start >= end - 1) {
            return pairsCount;
        }
        int mid = start + (end - start) / 2;
        pairsCount += mergeSort(nums,start,mid,temp);
        pairsCount += mergeSort(nums,mid,end,temp);
        int i = start;
        int j = mid;
        int k = start;
        while (i < mid && j < end) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
                pairsCount += j - mid;
            }
        }
        final int rightL = j - mid;
        while (i < mid) {
            temp[k++] = nums[i++];
            pairsCount += rightL;
        }
        while (j < end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp,start,nums,start,end - start);
        return pairsCount;
    }

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums,0,nums.length,temp);
    }
}
