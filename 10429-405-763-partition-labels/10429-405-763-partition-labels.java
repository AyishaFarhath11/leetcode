class Solution {
    public List<Integer> partitionLabels(String s) {
                List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        // Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // If we reach the end of a partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}