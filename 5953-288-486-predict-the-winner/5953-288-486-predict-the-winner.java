class Solution {
    public boolean predictTheWinner(int[] nums) {
        
     final int n = nums.length;
        final int[][] dp = new int[n][n];

        for(int i = 0; i < n; ++i)
            Arrays.fill(dp[i], -1);

        return play(dp, 0, n - 1, nums) >= 0;
    }

    private int play(final int[][] dp, final int l, final int r, final int[] nums) {
        if(dp[l][r] != -1)
            return dp[l][r];

        if(l == r)
            return nums[l];

        final int left = nums[l] - play(dp, l + 1, r, nums), right = nums[r] - play(dp, l, r - 1, nums);

        dp[l][r] = Math.max(left, right);

        return dp[l][r];
    }
}