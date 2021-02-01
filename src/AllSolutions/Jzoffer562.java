package AllSolutions;

public class Jzoffer562 {
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < count.length; ++i) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }
        for (int i = count.length - 1; i >= 0; --i) {
            result <<= 1;
            result += count[i] % 3;
        }
        return result;
    }
}
