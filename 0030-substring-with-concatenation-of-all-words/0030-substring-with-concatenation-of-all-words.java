class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
                List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();

        // Count the frequency of each word in `words`
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate over all possible starting points for the sliding window
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentCount = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);

                    if (currentCount.get(word) <= wordCount.get(word)) {
                        count++;
                    } else {
                        while (currentCount.get(word) > wordCount.get(word)) {
                            String leftWord = s.substring(left, left + wordLength);
                            currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                            if (currentCount.get(leftWord) < wordCount.get(leftWord)) {
                                count--;
                            }
                            left += wordLength;
                        }
                    }

                    if (count == words.length) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                } else {
                    currentCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}