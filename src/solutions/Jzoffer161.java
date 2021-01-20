package solutions;

public class Jzoffer161 {
    public double myPow(double x, final int n) {
        if (x == 0){
            return 0;
        }
        long b = n;
        if(b < 0){
            b = -b;  // If b = INT_MIN and the type of b is int, overflow will occur!
            x = 1.0 / x;
        }
        double result = 1.0;
        while (b > 0){
            if((b & 1) == 1){
                result *= x;
            }
            x *= x;
            b >>>= 1;
        }
        return result;
    }
}
