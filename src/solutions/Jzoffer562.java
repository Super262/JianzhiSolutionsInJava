package solutions;

public class Jzoffer562 {
    public int singleNumber(int[] nums) {
        if(nums.length < 4){
            return nums[0];
        }
        final int INT_LENGTH = 32;
        int[] count = new int[INT_LENGTH];
        for(int num : nums){
            for(int i = 0; i < INT_LENGTH; ++i){
                count[i] += (num & 1);
                num >>>= 1;
            }
        }
        int result = 0;
        for(int j = INT_LENGTH - 1; j >= 0; --j){
            result += (count[j] % 3);
            result <<= 1;
        }
        result >>>= 1;
        return result;
    }
}
