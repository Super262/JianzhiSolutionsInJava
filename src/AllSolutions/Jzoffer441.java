package AllSolutions;

public class Jzoffer441 {
    public int findNthDigit(final int n) {
        if(n < 10){
            return n;
        }

        // Each of these indices ranges from 1 to n.
        long maxValue = 99;
        long numWidth = 2;
        long minValue = 10;
        long maxIndex = (maxValue - minValue + 1) * numWidth;
        long currentIndex = n - 9;

        while (currentIndex > maxIndex){
            ++numWidth;
            currentIndex -= maxIndex;
            minValue *= 10;
            maxValue = (maxValue + 1) * 10 - 1;
            maxIndex = (maxValue - minValue + 1) * numWidth;
        }

        long blockValue = minValue + (currentIndex / numWidth) - 1;
        int blockOffset = (int)(currentIndex % numWidth);
        if(blockOffset != 0){
            ++blockValue;
            return String.valueOf(blockValue).charAt(blockOffset - 1) - '0';
        } else {
            return (int)(blockValue % 10);
        }
    }
}
