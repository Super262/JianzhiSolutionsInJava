package solutions;

public class Jzoffer142 {
    public int cuttingRope(int n) {
        if (n == 2 || n == 3){
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            n = n - 3;
            res = res * 3 % 1000000007;
        }
        return (int)((n * res) % 1000000007);
    }
}
