package solutions;

public class Jzoffer511 {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length);
    }
    private int mergeSort(int[] nums, int[] temp, final int start,final int end){
        if(start == end - 1){
            return 0;
        }
        final int mid = (start + end) / 2;
        int result = mergeSort(nums, temp, start, mid) + mergeSort(nums, temp, mid, end);

        int leftIt = start, rightIt = mid, tempIt = 0;
        while(leftIt < mid && rightIt < end){
            if(nums[leftIt] <= nums[rightIt]){
                result += (rightIt - mid);
                temp[tempIt++] = nums[leftIt++];
            } else {
                temp[tempIt++] = nums[rightIt++];
            }
        }

        final int tempCount = rightIt - mid;
        while(leftIt < mid){
            temp[tempIt++] = nums[leftIt++];
            result += tempCount;
        }

        while(rightIt < end){
            temp[tempIt++] = nums[rightIt++];
        }

        System.arraycopy(temp, 0, nums, start, tempIt);
        return result;
    }
}
