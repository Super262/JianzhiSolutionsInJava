package AllSolutions;

public class Jzoffer651 {
    public int add(int a,int b) {
        int c;
        while (b != 0) {
            c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
