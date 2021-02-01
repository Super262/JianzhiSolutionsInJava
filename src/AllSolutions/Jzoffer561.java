package AllSolutions;

public class Jzoffer561 {
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int aXORb = 0;
        for (int num : nums) {
            aXORb ^= num;
        }
        int div = 1;
        while ((div & aXORb) == 0) {
            div <<= 1;
        }
        for (int num : nums) {
            if ((div & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
