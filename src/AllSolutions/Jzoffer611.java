package AllSolutions;

import java.util.Arrays;

public class Jzoffer611 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int zerosCount = 0;
        while (j < 5) {
            if (nums[i] == 0 && nums[j] == 0) {
                j += 2;
                i += 2;
                zerosCount += 2;
            } else {
                if (nums[i] != 0 && nums[j] != 0) {
                    if (nums[j] != nums[i]) {
                        zerosCount -= nums[j] - nums[i] - 1;
                    } else {
                        return false;
                    }
                    ++i;
                } else {
                    if (nums[i] == 0) {
                        ++i;
                    }
                    ++zerosCount;
                }
                ++j;
            }
        }
        return zerosCount >= 0;
    }
}
