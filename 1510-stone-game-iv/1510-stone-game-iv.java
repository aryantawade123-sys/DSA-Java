class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false; // no stones → lose

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s * s <= i; s++) {
                if (!dp[i - s * s]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
