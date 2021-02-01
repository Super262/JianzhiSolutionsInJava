package AllSolutions;

public class Jzoffer101 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = -1, x = 0, y = 1;
        for (int i = 2; i < n + 1; ++i) {

            // Note: We must reduce the result to the range every time.
            result = (x + y) % 1000000007;
            x = y;
            y = result;
        }
        return result;
    }
}
