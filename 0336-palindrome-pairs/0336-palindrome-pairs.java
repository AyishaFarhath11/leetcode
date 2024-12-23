class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
         List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        
        // Populate the wordMap with the words and their corresponding indices.
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        
        // Iterate through each word and check for palindrome pairs.
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            // Check all possible splits of the word into two substrings.
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                // Case 1: If the left part is a palindrome, check if the reversed right part exists in the wordMap.
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (wordMap.containsKey(reversedRight) && wordMap.get(reversedRight) != i) {
                        result.add(List.of(wordMap.get(reversedRight), i));
                    }
                }
                
                // Case 2: If the right part is a palindrome, check if the reversed left part exists in the wordMap.
                if (isPalindrome(right) && right.length() > 0) { // Avoid duplicate cases where left is empty
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (wordMap.containsKey(reversedLeft) && wordMap.get(reversedLeft) != i) {
                        result.add(List.of(i, wordMap.get(reversedLeft)));
                    }
                }
            }
        }
        
        return result;
    }
     private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}