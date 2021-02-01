package AllSolutions;

public class Jzoffer211 {
    public int[] exchange(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, temp;
        while (p1 < p2) {
            while (nums[p1] % 2 == 1 && p1 < p2) {
                ++p1;
            }
            while (nums[p2] % 2 == 0 && p2 > p1) {
                --p2;
            }
            if (p1 < p2) {
                temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }
        return nums;
    }
}
