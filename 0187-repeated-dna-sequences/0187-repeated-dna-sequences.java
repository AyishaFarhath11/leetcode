class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // Iterate through the string to find all 10-letter-long substrings
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);

            // If the substring has been seen before, add it to the repeated set
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }

        // Convert the repeated set to a list
        return new ArrayList<>(repeated);
    }
}