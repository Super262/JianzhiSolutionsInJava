package AllSolutions;

public class Jzoffer431 {
    public int countDigitOne(final int n) {
        long countOfDigitOne = 0;

        long base = 10;
        long digit = 1;

        long high = n / base;
        long cur = n % base;
        long low = 0;

        while (low != n) {
            if (cur == 0) {
                countOfDigitOne += (high * digit);
            } else if (cur == 1) {
                countOfDigitOne += high * digit + low + 1;
            } else {
                countOfDigitOne += (high + 1) * digit;
            }
            base *= 10;
            digit *= 10;
            high = n / base;
            cur = (n % base) / digit;
            low = n % digit;
        }
        return (int) countOfDigitOne;
    }
}
