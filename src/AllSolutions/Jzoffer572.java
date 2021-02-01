package AllSolutions;

import java.util.LinkedList;

public class Jzoffer572 {
    public int[][] findContinuousSequence(int target) {
        if(target < 3){
            return new int[][]{};
        }
        LinkedList<int[]> result = new LinkedList<>();
        int i = 1;
        int j = 2;
        int tempSum;
        int[] tempResult;
        while(i < j && j <= target){
            tempSum = (i + j) * (j - i + 1) / 2;
            if(tempSum == target){
                tempResult = new int[j - i + 1];
                for(int k = 0; k < tempResult.length; ++k){
                    tempResult[k] = i + k;
                }
                result.add(tempResult);
                ++i;
            } else if (tempSum > target){
                ++i;
            } else {
                ++j;
            }
        }
        int[][] res = new int[result.size()][];
        result.toArray(res);
        return res;
    }
}
