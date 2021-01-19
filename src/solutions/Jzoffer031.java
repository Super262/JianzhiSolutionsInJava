package solutions;

public class Jzoffer031 {
    public int findRepeatNumber(int[] nums) {
        boolean[] repeated = new boolean[nums.length];
        for (int num : nums) {
            if (repeated[num]) {
                return num;
            } else {
                repeated[num] = true;
            }
        }
        return -1;
    }
}
