package AllSolutions;

public class Jzoffer532 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        for(int i = 0; i < nums.length; ++i){
            if(i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
