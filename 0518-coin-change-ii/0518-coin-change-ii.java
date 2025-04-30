class Solution {
    public int change(int amount, int[] coins) {
         int n = coins.length;
        long[][] dp = new long[n][amount + 1]; // use long[][] since the recursion returns long

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (long[] row : dp)
            Arrays.fill(row, -1);

        // Call the helper and cast the result to int since the return type is int
        return (int) countWaysToMakeChangeUtil(coins, n - 1, amount, dp);
    }

    static long countWaysToMakeChangeUtil(int[] coins, int ind, int amount, long[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            if (amount % coins[0] == 0)
                return 1;
            else
                return 0;
        }

        // If already computed
        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        // Don't take the current coin
        long notTaken = countWaysToMakeChangeUtil(coins, ind - 1, amount, dp);

        // Take the coin if it's <= amount
        long taken = 0;
        if (coins[ind] <= amount)
            taken = countWaysToMakeChangeUtil(coins, ind, amount - coins[ind], dp);

        // Memoize and return
        return dp[ind][amount] = notTaken + taken;
    }
}