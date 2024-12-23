class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
          Set<String> wordSet = new HashSet<>(wordDict); // Convert list to set for O(1) lookup
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }
      private static List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add(""); // Base case: add an empty string
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixResults = backtrack(s.substring(i), wordSet, memo);
                for (String suffix : suffixResults) {
                    result.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }

        memo.put(s, result); // Store result in memo to avoid recomputation
        return result;
    }
}