class Solution {
    public int minDistance(String word1, String word2) {
         int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return editDistanceUtil(word1, word2, n - 1, m - 1, dp);
    }
    static int editDistanceUtil(String word1, String word2, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        // If the result is already computed, return it
        if (dp[i][j] != -1)
            return dp[i][j];

        // If the characters at the current positions match, no edit is needed
        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = editDistanceUtil(word1, word2, i - 1, j - 1, dp);

        // Minimum of three choices:
        // 1. Replace the character in word1 with the character in word2.
        // 2. Delete the character in word1.
        // 3. Insert the character from word2 into word1.
        else
            return dp[i][j] = 1 + Math.min(editDistanceUtil(word1, word2, i - 1, j - 1, dp),
                    Math.min(editDistanceUtil(word1, word2, i - 1, j, dp), editDistanceUtil(word1, word2, i, j - 1, dp)));
    }
}