package solutions;

// Dynamic Programming
public class Jzoffer421 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        int max = dp[0];
        for(int num : dp){
            max = Math.max(num,max);
        }
        return max;
    }
}
