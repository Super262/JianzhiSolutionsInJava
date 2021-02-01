package AllSolutions;

public class Jzoffer641 {
    public int sumNums(int n) {
        return quickMultiply(n, n + 1) >> 1;
    }

    private int quickMultiply(int a, int b){
        int result = 0;
        while(b != 0){
            result += (b & 1) == 1 ? a : 0;
            a <<= 1;
            b >>>= 1;
        }
        return result;
    }
}
