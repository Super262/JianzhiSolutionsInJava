package HardProblems;

public class Jzoffer161 {
    public double myPow(double x,int n) {
        boolean negExpo = n < 0;
        n = Math.abs(n);
        double result = 1;
        while (n != 0) {
            result *= (n & 1) == 0? 1: x;
            x *= x;
            n >>>= 1;
        }
        result = negExpo ? 1.0 / result : result;
        return result;
    }
}
