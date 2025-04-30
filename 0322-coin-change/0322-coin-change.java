class Solution {
    public int coinChange(int[] coins, int amount) {
int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Initialize dp with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = minCoins(coins, n - 1, amount, dp);

        return ans >= (int)1e9 ? -1 : ans;
    }

    static int minCoins(int[] coins, int ind, int amount, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int)1e9; // impossible
        }

        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        int notTake = minCoins(coins, ind - 1, amount, dp);

        int take = (int)1e9;
        if (coins[ind] <= amount)
            take = 1 + minCoins(coins, ind, amount - coins[ind], dp);

        return dp[ind][amount] = Math.min(take, notTake);
    }
}