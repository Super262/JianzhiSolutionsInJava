package AllSolutions;


// Dynamic Programming
public class Jzoffer601 {
    public double[] dicesProbability(int n) {
        if (n <= 0) {
            return new double[0];
        }
        int[][] eventsCount = new int[n + 1][];
        eventsCount[1] = new int[]{0,1,1,1,1,1,1};

        int allEvents = 6;
        int curMax;
        int prevMax = 6;
        int prevMin = 1;
        int tempDis;
        for (int i = 2; i <= n; ++i) {
            curMax = prevMax + 6;
            eventsCount[i] = new int[curMax + 1];
            for (int sum = i; sum <= curMax; ++sum) {
                for (int k = 1; k <= 6; ++k) {
                    tempDis = sum - k;
                    if (tempDis <= prevMax && tempDis >= prevMin) {
                        eventsCount[i][sum] += eventsCount[1][k] * eventsCount[i - 1][tempDis];
                    }
                }
            }
            prevMax = curMax;
            prevMin = i;
            allEvents *= 6;
        }
        double[] result = new double[prevMax - prevMin + 1];
        for (int i = 0; i < result.length; ++i) {
            result[i] = eventsCount[n][i + n] / (double) allEvents;
        }
        return result;
    }
}
