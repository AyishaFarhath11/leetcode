class Solution {
    public int longestPalindromeSubseq(String s) {
    int n = s.length();
        String reversed = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];

        // Compute LCS of s and its reverse (which is the LPS)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];
    }    
    
}