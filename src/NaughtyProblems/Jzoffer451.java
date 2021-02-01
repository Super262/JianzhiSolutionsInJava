package NaughtyProblems;

import java.util.Arrays;

public class Jzoffer451 {
    public String minNumber(int[] nums) {
        String[] strNums = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strNums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        return String.join("", strNums);
    }
}
