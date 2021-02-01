package AllSolutions;


// Dynamic Programming
public class Jzoffer601 {
    public double[] dicesProbability(int n) {
        final int numType = 6;
        int[][] tempResult = new int[n + 1][];

        for(int i = 1; i <= n; ++i){
            tempResult[i] = new int[i * numType + 1];
        }
        for (int i = 1; i < tempResult[1].length; ++i){
            tempResult[1][i] = 1;
        }

        for (int i = 2; i <= n; ++i){
            for(int j = i; j < i * numType + 1; ++j){
                for(int k = 1; k <= numType; ++k){
                    if(j - k >= i - 1 && j - k < tempResult[i - 1].length){
                        tempResult[i][j] += tempResult[1][k] * tempResult[i - 1][j - k];
                    }
                }
            }
        }

        double[] result = new double[n * 5 + 1];
        int nCount = (int)Math.pow(numType, n);
        for(int i = n; i < tempResult[n].length; ++i){
            result[i - n] = tempResult[n][i] / (double)nCount;
        }
        return result;
    }
}
