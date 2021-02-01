package AllSolutions;

public class Jzoffer621 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for(int i = 1; i <= n; ++i){
            x = (x + m) % i;
        }
        return x;
    }
}
