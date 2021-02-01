package AllSolutions;

import java.util.ArrayList;

public class Jzoffer491 {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);

        int[] base = {2,3,5};
        int[] basePointers = new int[3];
        int[] tempResults = new int[3];

        int nextMin;
        while (n > uglyNumbers.size()) {
            nextMin = Integer.MAX_VALUE;
            for (int i = 0; i < 3; ++i) {
                tempResults[i] = base[i] * uglyNumbers.get(basePointers[i]);
                nextMin = Math.min(nextMin,tempResults[i]);
            }
            for (int i = 0; i < 3; ++i) {
                if (tempResults[i] == nextMin) {
                    ++basePointers[i];
                }
            }
            uglyNumbers.add(nextMin);
        }
        return uglyNumbers.get(n - 1);
    }
}
