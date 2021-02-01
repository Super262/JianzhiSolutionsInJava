package AllSolutions;

public class Jzoffer171 {
    public int[] printNumbers(int n) {
        if(n <= 0){
            return new int[0];
        }
        final int resultLength = (int)Math.pow(10, n) - 1;
        int[] result = new int[resultLength];
        for(int i = 0; i < resultLength; ++i){
            result[i] = i + 1;
        }
        return result;
    }
}
