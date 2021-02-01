package AllSolutions;

public class Jzoffer531 {
    public int search(int[] nums,int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchBinary(nums,0,nums.length - 1,target);
    }

    private int searchBinary(int[] nums,int start,int end,int target) {
        if (start == end) {
            return nums[start] == target ? 1 : 0;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return searchBinary(nums,start,mid,target) + searchBinary(nums,mid + 1,end,target);
        } else if (nums[mid] > target) {
            return searchBinary(nums,start,mid,target);
        } else {
            return searchBinary(nums,mid + 1,end,target);
        }
    }
}