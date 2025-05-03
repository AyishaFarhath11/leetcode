class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         Set<String> wordSet = new HashSet<>(wordDict); // Convert the list to a set for faster lookups
        boolean[] dp = new boolean[s.length() + 1]; // DP array to store results for substrings
        dp[0] = true; // Base case: empty string can always be segmented
        
        // Iterate through the string
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if substring from j to i is in the wordSet and dp[j] is true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}