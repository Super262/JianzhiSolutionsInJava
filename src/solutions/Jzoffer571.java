package solutions;

public class Jzoffer571 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2 || target > nums[nums.length - 1] + nums[nums.length - 2] || target < nums[0] + nums[1]){
            return new int[]{};
        }
        int i = 0, j = nums.length - 1;
        int tempSum;
        while(i < j){
            tempSum = nums[i] + nums[j];
            if(tempSum == target){
                return new int[]{nums[i], nums[j]};
            } else if (tempSum > target){
                --j;
            } else {
                ++i;
            }
        }
        return new int[]{};
    }
}
