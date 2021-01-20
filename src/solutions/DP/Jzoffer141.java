package solutions.DP;

public class Jzoffer141 {
    public int cuttingRope(int n) {
        // dp[i] = max{dp[i], max{(i - j) * j, dp[i - j] * j}}, (1 <= j <= i - 1, 2 <= i <= n)
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; ++i){
            for (int j = 1; j < i; ++j){
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
