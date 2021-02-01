package AllSolutions;

public class Jzoffer391 {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int result = nums[0];
        for (int num : nums) {
            result = votes == 0 ? num : result;
            votes += (num == result ? 1 : -1);
        }
        return result;
    }
}
